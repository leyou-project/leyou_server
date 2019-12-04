/*
 * 作者：刘时明
 * 时间：2019/11/24-0:14
 * 作用：
 */
package com.leyou.logs.service;

import com.leyou.common.domain.TLog;

public interface LogsService extends RPCLogsService
{
    int save(TLog log);
}
