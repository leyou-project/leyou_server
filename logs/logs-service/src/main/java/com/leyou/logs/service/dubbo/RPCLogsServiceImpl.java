/**
 * 作者：刘时明
 * 时间：2019/11/26-18:48
 * 作用：
 */
package com.leyou.logs.service.dubbo;

import com.leyou.common.domain.TLog;
import com.leyou.logs.service.LogsService;
import com.leyou.logs.service.RPCLogsService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service(version = "1.0.0", timeout = 5000)
public class RPCLogsServiceImpl implements RPCLogsService
{
    @Autowired
    private LogsService logsService;

    @Override
    public List<TLog> filterQuery(Map<String, Object> filter)
    {
        return logsService.filterQuery(filter);
    }

    @Override
    public TLog get(Long id)
    {
        return logsService.get(id);
    }
}
