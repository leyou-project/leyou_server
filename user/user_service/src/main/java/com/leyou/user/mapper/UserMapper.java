/**
 * 作者：刘时明
 * 时间：2019/11/2-15:54
 * 作用：
 */
package com.leyou.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leyou.domain.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User>
{
}
