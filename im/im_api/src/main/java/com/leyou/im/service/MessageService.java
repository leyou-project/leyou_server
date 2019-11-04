/**
 * 作者：刘时明
 * 时间：2019/11/4-17:11
 * 作用：
 */
package com.leyou.im.service;

import com.leyou.domain.im.Message;

import java.util.List;

public interface MessageService
{
    /**
     * 单点消息
     *
     * @param formId
     * @param toId
     * @param content
     * @return
     */
    boolean sendSinglePointMsg(int formId, int toId, byte[] content);

    /**
     * 群发消息
     *
     * @param formId
     * @param content
     * @param groupType
     * @return
     */
    boolean sendGroupMsg(int formId, byte[] content, int groupType);

    /**
     * 广播消息
     *
     * @param formId
     * @param content
     * @return
     */
    boolean sendBroadcastMsg(int formId, byte[] content);

    /**
     * 获取消息列表
     *
     * @param uid
     * @return
     */
    List<Message> messageList(int uid);


    /**
     * 修改消息状态，已读、删除
     *
     * @param id
     * @return
     */
    boolean changeMsgStatus(long id);
}
