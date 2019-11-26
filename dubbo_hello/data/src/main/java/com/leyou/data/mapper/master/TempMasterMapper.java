/*
 * 作者：刘时明
 * 时间：2019/11/26-23:20
 * 作用：
 */
package com.leyou.data.mapper.master;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TempMasterMapper
{
    @Insert("insert into t_temp values(#{id},#{name})")
    int insertTemp(@Param("id") int id, @Param("name") String name);
}
