/*
 * 作者：刘时明
 * 时间：2019/11/24-0:14
 * 作用：
 */
package com.leyou.logs.service;

import com.leyou.domain.TLog;

import java.util.List;
import java.util.Map;

public interface RPCLogsService
{
    List<TLog> filterQuery(Map<String, Object> filter);

    TLog get(Long id);
}
