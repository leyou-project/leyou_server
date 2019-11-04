/**
 * 作者：刘时明
 * 时间：2019/11/4-18:32
 * 作用：
 */
package com.leyou.im.service.impl;

import com.leyou.domain.im.Message;
import com.leyou.im.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService
{
    @Override
    public boolean sendSinglePointMsg(int formId, int toId, byte[] content)
    {
        return false;
    }

    @Override
    public boolean sendGroupMsg(int formId, byte[] content, int groupType)
    {
        return false;
    }

    @Override
    public boolean sendBroadcastMsg(int formId, byte[] content)
    {
        return false;
    }

    @Override
    public List<Message> messageList(int uid)
    {
        return null;
    }

    @Override
    public boolean changeMsgStatus(long id)
    {
        return false;
    }
}
