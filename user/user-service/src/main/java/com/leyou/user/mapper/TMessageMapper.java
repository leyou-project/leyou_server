package com.leyou.user.mapper;

import com.leyou.domain.TMessage;

import java.util.List;

import com.leyou.domain.TMessageExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface TMessageMapper
{
    @SelectProvider(type = TMessageSqlProvider.class, method = "countByExample")
    long countByExample(TMessageExample example);

    @DeleteProvider(type = TMessageSqlProvider.class, method = "deleteByExample")
    int deleteByExample(TMessageExample example);

    @Delete({
            "delete from t_message",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into t_message (to_id, form_id, ",
            "type, title, status, ",
            "update_time, create_time, ",
            "content)",
            "values (#{toId,jdbcType=BIGINT}, #{formId,jdbcType=INTEGER}, ",
            "#{type,jdbcType=BIT}, #{title,jdbcType=VARCHAR}, #{status,jdbcType=BIT}, ",
            "#{updateTime,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT}, ",
            "#{content,jdbcType=LONGVARBINARY})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TMessage record);

    @InsertProvider(type = TMessageSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TMessage record);

    @SelectProvider(type = TMessageSqlProvider.class, method = "selectByExampleWithBLOBs")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "to_id", property = "toId", jdbcType = JdbcType.BIGINT),
            @Result(column = "form_id", property = "formId", jdbcType = JdbcType.INTEGER),
            @Result(column = "type", property = "type", jdbcType = JdbcType.BIT),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "content", property = "content", jdbcType = JdbcType.LONGVARBINARY)
    })
    List<TMessage> selectByExampleWithBLOBs(TMessageExample example);

    @SelectProvider(type = TMessageSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "to_id", property = "toId", jdbcType = JdbcType.BIGINT),
            @Result(column = "form_id", property = "formId", jdbcType = JdbcType.INTEGER),
            @Result(column = "type", property = "type", jdbcType = JdbcType.BIT),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT)
    })
    List<TMessage> selectByExample(TMessageExample example);

    @Select({
            "select",
            "id, to_id, form_id, type, title, status, update_time, create_time, content",
            "from t_message",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "to_id", property = "toId", jdbcType = JdbcType.BIGINT),
            @Result(column = "form_id", property = "formId", jdbcType = JdbcType.INTEGER),
            @Result(column = "type", property = "type", jdbcType = JdbcType.BIT),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "content", property = "content", jdbcType = JdbcType.LONGVARBINARY)
    })
    TMessage selectByPrimaryKey(Long id);

    @UpdateProvider(type = TMessageSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TMessage record, @Param("example") TMessageExample example);

    @UpdateProvider(type = TMessageSqlProvider.class, method = "updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") TMessage record, @Param("example") TMessageExample example);

    @UpdateProvider(type = TMessageSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") TMessage record, @Param("example") TMessageExample example);

    @UpdateProvider(type = TMessageSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TMessage record);

    @Update({
            "update t_message",
            "set to_id = #{toId,jdbcType=BIGINT},",
            "form_id = #{formId,jdbcType=INTEGER},",
            "type = #{type,jdbcType=BIT},",
            "title = #{title,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=BIT},",
            "update_time = #{updateTime,jdbcType=BIGINT},",
            "create_time = #{createTime,jdbcType=BIGINT},",
            "content = #{content,jdbcType=LONGVARBINARY}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(TMessage record);

    @Update({
            "update t_message",
            "set to_id = #{toId,jdbcType=BIGINT},",
            "form_id = #{formId,jdbcType=INTEGER},",
            "type = #{type,jdbcType=BIT},",
            "title = #{title,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=BIT},",
            "update_time = #{updateTime,jdbcType=BIGINT},",
            "create_time = #{createTime,jdbcType=BIGINT}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TMessage record);
}