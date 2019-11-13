/*
 * 作者：刘时明
 * 时间：2019/11/12-21:53
 * 作用：
 */
package com.leyou.im.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leyou.domain.im.Message;
import com.leyou.im.dao.ImDao;
import com.leyou.im.service.ImService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImServiceImpl implements ImService
{
    @Autowired
    private ImDao imDao;

    @Override
    public Page<Message> getOffLineMessage(int page, int size)
    {
        return null;
    }

    @Override
    public void updateMessage(int[] ids, int status)
    {

    }
}
