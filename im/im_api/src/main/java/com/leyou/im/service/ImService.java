/*
 * 作者：刘时明
 * 时间：2019/11/12-21:37
 * 作用：
 */
package com.leyou.im.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leyou.domain.im.Message;

public interface ImService
{
    /**
     * 获取消息列表
     *
     * @param page
     * @param size
     * @return
     */
    Page<Message> getOffLineMessage(int page, int size);

    /**
     * 更新消息
     *
     * @param ids
     */
    void updateMessage(int[] ids, int status);
}
