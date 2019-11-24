/*
 * 作者：刘时明
 * 时间：2019/11/12-21:37
 * 作用：
 */
package com.leyou.im.service;

import com.leyou.bean.PageList;
import com.leyou.domain.TMessage;

public interface RPCImService
{
    /**
     * 发送消息
     * @param formId
     * @param toId
     * @param msg
     * @return
     */
    boolean sendMsg(int formId,int toId,String msg);

    /**
     * 广播消息
     * @param title
     * @param msg
     */
    void broadcast(String title,String msg);

    /**
     * 获取消息列表
     *
     * @param page
     * @param size
     * @return
     */
    PageList<TMessage> getOffLineMessage(int page, int size);
}
