/*
 * 作者：刘时明
 * 时间：2019/11/6-0:22
 * 作用：
 */
package com.leyou.im.handler;

import com.leyou.im.handler.message.MsgReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint("/im/{token}")
public class SocketServer
{
    private static MsgReceiver receiver;

    @Autowired void setRedisReceiver(MsgReceiver receiver) {
        SocketServer.receiver=receiver;
    }

    @OnOpen
    public void onOpen(Session session,@PathParam("token") String token)
    {
        receiver.onOpen(session,token);
    }

    @OnClose
    public void onClose(Session session)
    {
        receiver.onClose(session);
    }

    @OnMessage
    public void onMessage(String message, Session session)
    {
        receiver.onMessage(message,session);
    }

    @OnError
    public void onError(Session session, Throwable error)
    {
        receiver.onError(session,error);
    }
}
