package com.leyou.im.mapper;

import com.leyou.domain.TMessage;
import com.leyou.domain.TMessageExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface TMessageMapper {
    @SelectProvider(type=TMessageSqlProvider.class, method="countByExample")
    long countByExample(TMessageExample example);

    @DeleteProvider(type=TMessageSqlProvider.class, method="deleteByExample")
    int deleteByExample(TMessageExample example);

    @Delete({
        "delete from t_message",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_message (to_id, form_id, ",
        "code, type, title, ",
        "status, update_time, ",
        "create_time, content)",
        "values (#{toId,jdbcType=INTEGER}, #{formId,jdbcType=INTEGER}, ",
        "#{code,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{updateTime,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=BIGINT}, #{content,jdbcType=LONGVARBINARY})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(TMessage record);

    @InsertProvider(type=TMessageSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(TMessage record);

    @SelectProvider(type=TMessageSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="to_id", property="toId", jdbcType=JdbcType.INTEGER),
        @Result(column="form_id", property="formId", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<TMessage> selectByExampleWithBLOBs(TMessageExample example);

    @SelectProvider(type=TMessageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="to_id", property="toId", jdbcType=JdbcType.INTEGER),
        @Result(column="form_id", property="formId", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT)
    })
    List<TMessage> selectByExample(TMessageExample example);

    @Select({
        "select",
        "id, to_id, form_id, code, type, title, status, update_time, create_time, content",
        "from t_message",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="to_id", property="toId", jdbcType=JdbcType.INTEGER),
        @Result(column="form_id", property="formId", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARBINARY)
    })
    TMessage selectByPrimaryKey(Long id);

    @UpdateProvider(type=TMessageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TMessage record, @Param("example") TMessageExample example);

    @UpdateProvider(type=TMessageSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") TMessage record, @Param("example") TMessageExample example);

    @UpdateProvider(type=TMessageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TMessage record, @Param("example") TMessageExample example);

    @UpdateProvider(type=TMessageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TMessage record);

    @Update({
        "update t_message",
        "set to_id = #{toId,jdbcType=INTEGER},",
          "form_id = #{formId,jdbcType=INTEGER},",
          "code = #{code,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT},",
          "content = #{content,jdbcType=LONGVARBINARY}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(TMessage record);

    @Update({
        "update t_message",
        "set to_id = #{toId,jdbcType=INTEGER},",
          "form_id = #{formId,jdbcType=INTEGER},",
          "code = #{code,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TMessage record);
}