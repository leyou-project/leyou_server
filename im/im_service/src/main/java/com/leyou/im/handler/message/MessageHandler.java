/*
 * 作者：刘时明
 * 时间：2019/11/8-22:13
 * 作用：
 */
package com.leyou.im.handler.message;

import com.leyou.im.dao.ImDao;
import com.leyou.domain.im.Message;
import com.leyou.im.utils.CmdCode;
import com.leyou.im.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MessageHandler
{
    @Autowired
    private ImDao imDao;

    public static Map<Long, Session> userMap = new ConcurrentHashMap<>();

    public void message(String msg)
    {
        char tag = msg.charAt(0);
        msg = msg.substring(1);
        if (tag == '0')
        {
            removeBySessionId(msg);
            return;
        } else if (tag == '1')
        {
            Message message;
            try
            {
                message = MessageUtil.strToMsg(msg);
            } catch (Exception e)
            {
                e.printStackTrace();
                return;
            }
            int code = message.getCode();
            Long formId = message.getFormId();
            Long toId = message.getToId();
            String content = message.getContent();
            switch (code)
            {
                case CmdCode.CODE_PING:
                    System.out.println("ping");
                    break;
                case CmdCode.CODE_PRIVATE_MSG:
                    sendMsg(formId, toId, content,null);
                    break;
            }
        }
    }

    public static void removeBySessionId(String sessionId)
    {
        for (Map.Entry<Long, Session> entry : userMap.entrySet())
        {
            if (entry.getValue().getId().equals(sessionId))
            {
                userMap.remove(entry.getKey());
                break;
            }
        }
    }

    public void sendMsg(Long formId, Long toId, String content,String title)
    {
        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        message.setToId(toId);
        message.setFormId(formId);
        message.setStatus(1);
        Date now=new Date();
        message.setCreateTime(now);
        if (toId == null)
        {
            message.setCode(CmdCode.CODE_BROADCAST);
            String msg = MessageUtil.msgToStr(message);
            for (Map.Entry<Long, Session> entry : userMap.entrySet())
            {
                send(entry.getValue(), msg);
            }
        } else
        {
            message.setCode(CmdCode.CODE_PRIVATE_MSG);
            send(userMap.get(toId), MessageUtil.msgToStr(message));
        }
        message.setUpdateTime(now);
        saveMsg(message);
    }

    @Async
    public void saveMsg(Message message)
    {
        imDao.save(message);
    }

    private void send(Session session, String msg)
    {
        if (session == null || msg == null)
        {
            System.out.println("session或者msg为空");
            return;
        }
        try
        {
            session.getBasicRemote().sendText(msg);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("发送一次");
    }
}
