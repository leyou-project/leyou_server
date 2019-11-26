package com.leyou.user.mapper;

import com.leyou.common.domain.TRole;

import java.util.List;

import com.leyou.common.domain.TRoleExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface TRoleMapper
{
    @SelectProvider(type = TRoleSqlProvider.class, method = "countByExample")
    long countByExample(TRoleExample example);

    @DeleteProvider(type = TRoleSqlProvider.class, method = "deleteByExample")
    int deleteByExample(TRoleExample example);

    @Delete({
            "delete from t_role",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into t_role (role_name, update_time, ",
            "create_time)",
            "values (#{roleName,jdbcType=VARCHAR}, #{updateTime,jdbcType=BIGINT}, ",
            "#{createTime,jdbcType=BIGINT})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TRole record);

    @InsertProvider(type = TRoleSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TRole record);

    @SelectProvider(type = TRoleSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "role_name", property = "roleName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT)
    })
    List<TRole> selectByExample(TRoleExample example);

    @Select({
            "select",
            "id, role_name, update_time, create_time",
            "from t_role",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "role_name", property = "roleName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT)
    })
    TRole selectByPrimaryKey(Long id);

    @UpdateProvider(type = TRoleSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TRole record, @Param("example") TRoleExample example);

    @UpdateProvider(type = TRoleSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") TRole record, @Param("example") TRoleExample example);

    @UpdateProvider(type = TRoleSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TRole record);

    @Update({
            "update t_role",
            "set role_name = #{roleName,jdbcType=VARCHAR},",
            "update_time = #{updateTime,jdbcType=BIGINT},",
            "create_time = #{createTime,jdbcType=BIGINT}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TRole record);
}