/*
 * 作者：刘时明
 * 时间：2019/11/9-14:07
 * 作用：
 */
package com.leyou.im.handler.message;

import com.leyou.im.dao.ImDao;
import com.leyou.domain.im.Message;
import com.leyou.im.handler.RedisTemplate;
import com.leyou.im.utils.CmdCode;
import com.leyou.im.utils.MessageUtil;
import com.leyou.utils.Snowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Set;

@Component
public class MsgReceiver
{
    @Value("${chat.allTopics}")
    private Set<String> allTopics;
    @Value("${chat.subTopic}")
    private String subTopic;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private Snowflake snowflake;
    @Autowired
    private ImDao imDao;

    @Transactional
    public void onOpen(Session session, String token)
    {
        // 便于测试不对token进行解析认证，直接token=用户ID
        try
        {
            long id = Long.parseLong(token);
            String secretKey = getSecretKey(id);
            if (secretKey != null)
            {
                hackAck(secretKey, session);
                MessageHandler.userMap.put(id, session);
                System.out.println("user=" + MessageHandler.userMap);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("一个错误连接：" + token);
        }
    }

    public void onClose(Session session)
    {
        // 发布下线消息
        for (String topic : allTopics)
        {
            redisTemplate.publish(topic, "0" + session.getId());
        }
    }

    public void onMessage(String message, Session session)
    {
        // 发布消息
        for (String topic : allTopics)
        {
            redisTemplate.publish(topic, "1" + message);
        }
    }

    public void onError(Session session, Throwable error)
    {
        // 发布下线消息
        for (String topic : allTopics)
        {
            redisTemplate.publish(topic, "0" + session.getId());
        }
    }

    private String getSecretKey(Long id)
    {
//        Optional<User> user = userDao.findById(id);
//        if (user.isPresent())
//        {
//            String secretKey = UUID.randomUUID().toString().substring(0, 5);
//            user.get().setSecretKey(secretKey);
//            userDao.updateSecretKey(secretKey, id);
//            return secretKey;
//        } else
//        {
//            return null;
//        }
        return null;
    }

    private void hackAck(String secretKey, Session session) throws IOException
    {
        Message data = new Message();
        data.setCode(CmdCode.CODE_HAKE_ACK);
        data.setId(snowflake.nextId());
        data.setContent(secretKey);
        session.getBasicRemote().sendText(MessageUtil.msgToStr(data));
    }
}
