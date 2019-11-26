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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class TempServiceImpl
{
    @Autowired
    private TempMasterMapper masterMapper;
    @Autowired
    private TempSlaveMapper slaveMapper;

    @Qualifier("clusterDataSource")
    @Autowired
    private DataSource clusterDataSource;

    public int save(int id,String name)
    {
        System.out.println("masterMapper="+masterMapper);
        return masterMapper.insertTemp(id,name);
    }

    public List<Temp> list()
    {
        System.out.println("slaveMapper="+slaveMapper);
        try
        {
            System.out.println("clusterDataSource="+clusterDataSource);
            return slaveMapper.list();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
