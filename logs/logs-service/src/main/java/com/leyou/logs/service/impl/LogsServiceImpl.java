/*
 * 作者：刘时明
 * 时间：2019/11/24-0:17
 * 作用：
 */
package com.leyou.logs.service.impl;

import com.leyou.common.domain.TLog;
import com.leyou.common.domain.TLogExample;
import com.leyou.logs.mapper.TLogMapper;
import com.leyou.logs.service.LogsService;
import com.leyou.common.utils.Snowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LogsServiceImpl implements LogsService
{
    @Autowired
    private TLogMapper logMapper;
    @Autowired
    private Snowflake snowflake;

    @Override
    public int save(TLog log)
    {
        log.setId(snowflake.nextId());
        return logMapper.insert(log);
    }

    @Override
    public List<TLog> filterQuery(Map<String, Object> filter)
    {
        TLogExample example = new TLogExample();
        if (filter.containsKey("id"))
        {
            Long id = Long.parseLong(filter.get("id").toString());
            example.createCriteria().andIdEqualTo(id);
        }
        if (filter.containsKey("userId"))
        {
            Long userId = Long.parseLong(filter.get("userId").toString());
            example.createCriteria().andIdEqualTo(userId);
        }
        if (filter.containsKey("type"))
        {
            Integer type = Integer.parseInt(filter.get("type").toString());
            example.createCriteria().andTypeEqualTo(type);
        }
        return logMapper.selectByExample(example);
    }

    @Override
    public TLog get(Long id)
    {
        return logMapper.selectByPrimaryKey(id);
    }
}
