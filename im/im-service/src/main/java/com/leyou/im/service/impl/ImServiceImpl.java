/*
 * 作者：刘时明
 * 时间：2019/11/12-21:53
 * 作用：
 */
package com.leyou.im.service.impl;

import com.leyou.bean.PageList;
import com.leyou.domain.TMessage;
import com.leyou.im.handler.message.MsgReceiver;
import com.leyou.im.mapper.TMessageMapper;
import com.leyou.im.service.ImService;
import com.leyou.im.utils.MessageUtil;
import com.leyou.utils.Snowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImServiceImpl implements ImService
{
    @Autowired
    private TMessageMapper messageMapper;
    @Autowired
    private Snowflake snowflake;
    private static MsgReceiver receiver;

    @Autowired
    void setRedisReceiver(MsgReceiver receiver)
    {
        ImServiceImpl.receiver=receiver;
    }

    @Override
    public PageList<TMessage> getOffLineMessage(int page, int size)
    {
        return null;
    }

    @Override
    public boolean sendMsg(int formId, int toId, String msg)
    {
        TMessage message=new TMessage();
        message.setContent(msg.getBytes());
        message.setId(snowflake.nextId());
        message.setFormId(formId);
        long now=System.currentTimeMillis();
        message.setUpdateTime(now);
        message.setCreateTime(now);
        receiver.onMessage(MessageUtil.msgToStr(message));
        messageMapper.insert(message);
        return true;
    }

    @Override
    public void broadcast(String title, String msg)
    {

    }
}
