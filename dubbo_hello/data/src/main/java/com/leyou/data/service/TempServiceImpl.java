/*
 * 作者：刘时明
 * 时间：2019/11/26-23:11
 * 作用：
 */
package com.leyou.data.service;

import com.leyou.data.domain.Temp;
import com.leyou.data.mapper.cluster.TempSlaveMapper;
import com.leyou.data.mapper.master.TempMasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempServiceImpl
{
    @Autowired
    private TempMasterMapper masterMapper;
    @Autowired
    private TempSlaveMapper slaveMapper;

    public int save(int id, String name)
    {
        return masterMapper.insertTemp(id, name);
    }

    public List<Temp> list()
    {
        return slaveMapper.list();
    }
}
