package com.leyou.user.mapper;

import com.leyou.common.domain.TAuth;
import com.leyou.common.domain.TAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TAuthMapper {
    @SelectProvider(type=TAuthSqlProvider.class, method="countByExample")
    long countByExample(TAuthExample example);

    @DeleteProvider(type=TAuthSqlProvider.class, method="deleteByExample")
    int deleteByExample(TAuthExample example);

    @Delete({
        "delete from t_auth",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_auth (user_id, role_id, ",
        "update_time, create_time)",
        "values (#{userId,jdbcType=BIGINT}, #{roleId,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(TAuth record);

    @InsertProvider(type=TAuthSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(TAuth record);

    @SelectProvider(type=TAuthSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT)
    })
    List<TAuth> selectByExample(TAuthExample example);

    @Select({
        "select",
        "id, user_id, role_id, update_time, create_time",
        "from t_auth",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT)
    })
    TAuth selectByPrimaryKey(Long id);

    @UpdateProvider(type=TAuthSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TAuth record, @Param("example") TAuthExample example);

    @UpdateProvider(type=TAuthSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TAuth record, @Param("example") TAuthExample example);

    @UpdateProvider(type=TAuthSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TAuth record);

    @Update({
        "update t_auth",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "role_id = #{roleId,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TAuth record);
}