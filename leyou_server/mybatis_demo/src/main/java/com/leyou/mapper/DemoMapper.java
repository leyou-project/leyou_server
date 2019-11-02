/*
 * 作者：刘时明
 * 时间：2019/11/2-10:15
 * 作用：
 */
package com.leyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leyou.bean.Demo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper extends BaseMapper<Demo>
{
}
