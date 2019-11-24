package com.leyou.logs.mapper;

import com.leyou.domain.TLog;
import com.leyou.domain.TLogExample;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface TLogMapper
{
    @SelectProvider(type = TLogSqlProvider.class, method = "countByExample")
    long countByExample(TLogExample example);

    @DeleteProvider(type = TLogSqlProvider.class, method = "deleteByExample")
    int deleteByExample(TLogExample example);

    @Delete({
            "delete from t_log",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into t_log (user_id, level, ",
            "type, info, remake, ",
            "create_time)",
            "values (#{userId,jdbcType=BIGINT}, #{level,jdbcType=INTEGER}, ",
            "#{type,jdbcType=INTEGER}, #{info,jdbcType=VARCHAR}, #{remake,jdbcType=VARCHAR}, ",
            "#{createTime,jdbcType=BIGINT})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TLog record);

    @InsertProvider(type = TLogSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TLog record);

    @SelectProvider(type = TLogSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "level", property = "level", jdbcType = JdbcType.INTEGER),
            @Result(column = "type", property = "type", jdbcType = JdbcType.INTEGER),
            @Result(column = "info", property = "info", jdbcType = JdbcType.VARCHAR),
            @Result(column = "remake", property = "remake", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT)
    })
    List<TLog> selectByExample(TLogExample example);

    @Select({
            "select",
            "id, user_id, level, type, info, remake, create_time",
            "from t_log",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "level", property = "level", jdbcType = JdbcType.INTEGER),
            @Result(column = "type", property = "type", jdbcType = JdbcType.INTEGER),
            @Result(column = "info", property = "info", jdbcType = JdbcType.VARCHAR),
            @Result(column = "remake", property = "remake", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT)
    })
    TLog selectByPrimaryKey(Long id);

    @UpdateProvider(type = TLogSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TLog record, @Param("example") TLogExample example);

    @UpdateProvider(type = TLogSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") TLog record, @Param("example") TLogExample example);

    @UpdateProvider(type = TLogSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLog record);

    @Update({
            "update t_log",
            "set user_id = #{userId,jdbcType=BIGINT},",
            "level = #{level,jdbcType=INTEGER},",
            "type = #{type,jdbcType=INTEGER},",
            "info = #{info,jdbcType=VARCHAR},",
            "remake = #{remake,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=BIGINT}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TLog record);
}