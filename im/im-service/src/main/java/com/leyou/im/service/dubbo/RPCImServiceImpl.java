/*
 * 作者：刘时明
 * 时间：2019/11/24-22:13
 * 作用：
 */
package com.leyou.im.service.dubbo;

import com.leyou.common.bean.PageList;
import com.leyou.common.domain.TMessage;
import com.leyou.im.service.ImService;
import com.leyou.im.service.RPCImService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0",timeout = 5000)
public class RPCImServiceImpl implements RPCImService
{
    @Autowired
    private ImService imService;

    @Override
    public boolean sendMsg(int formId, int toId, String msg)
    {
        return false;
    }

    @Override
    public void broadcast(String title, String msg)
    {
        imService.broadcast(title, msg);
    }

    @Override
    public PageList<TMessage> getOffLineMessage(int page, int size)
    {
        return imService.getOffLineMessage(page, size);
    }
}
