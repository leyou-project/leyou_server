/*
 * 作者：刘时明
 * 时间：2019/11/26-23:20
 * 作用：
 */
package com.leyou.data.mapper.cluster;

import com.leyou.data.domain.Temp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TempSlaveMapper
{
    @Select("select * from t_temp")
    List<Temp> list();
}
