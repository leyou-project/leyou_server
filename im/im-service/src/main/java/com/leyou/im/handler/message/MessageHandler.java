/*
 * 作者：刘时明
 * 时间：2019/11/8-22:13
 * 作用：
 */
package com.leyou.im.handler.message;

import com.leyou.common.domain.TMessage;
import com.leyou.im.mapper.TMessageMapper;
import com.leyou.im.utils.CmdCode;
import com.leyou.im.utils.MessageUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MessageHandler
{
    @Autowired
    private TMessageMapper messageMapper;

    public static Map<Integer, SessionInfo> userMap = new ConcurrentHashMap<>();

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
            TMessage message;
            try
            {
                message = MessageUtil.strToMsg(msg);
            } catch (Exception e)
            {
                e.printStackTrace();
                return;
            }
            int code = message.getCode();
            int formId = message.getFormId();
            int toId = message.getToId();
            String content = new String(message.getContent());
            switch (code)
            {
                case CmdCode.CODE_PING:
                    System.out.println("ping");
                    break;
                case CmdCode.CODE_PRIVATE_MSG:
                    sendMsg(formId, toId, content.getBytes(),null);
                    break;
            }
        }
    }

    public static void removeBySessionId(String sessionId)
    {
        for (Map.Entry<Integer, SessionInfo> entry : userMap.entrySet())
        {
            if (entry.getValue().session.getId().equals(sessionId))
            {
                userMap.remove(entry.getKey());
                break;
            }
        }
    }

    public void sendMsg(int formId, int toId, byte[] content,String title)
    {
        TMessage message = new TMessage();
        message.setTitle(title);
        message.setContent(content);
        message.setToId(toId);
        message.setFormId(formId);
        message.setStatus(1);
        long now=System.currentTimeMillis();
        message.setCreateTime(now);
        if (toId == 0)
        {
            message.setCode(CmdCode.CODE_BROADCAST);
            String msg = MessageUtil.msgToStr(message);
            for (Map.Entry<Integer, SessionInfo> entry : userMap.entrySet())
            {
                send(entry.getValue().session, msg);
            }
        } else
        {
            message.setCode(CmdCode.CODE_PRIVATE_MSG);
            send(userMap.get(toId).session, MessageUtil.msgToStr(message));
        }
        message.setUpdateTime(now);
        saveMsg(message);
    }

    @Async
    public void saveMsg(TMessage message)
    {
        messageMapper.insert(message);
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

    @Data
    static class SessionInfo
    {
        private Session session;
        private String publicKey;
        private Integer ping;
    }
}
