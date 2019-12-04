package com.leyou.user.mapper;

import com.leyou.common.domain.TGroup;
import com.leyou.common.domain.TGroupExample;

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

public interface TGroupMapper
{
    @SelectProvider(type = TGroupSqlProvider.class, method = "countByExample")
    long countByExample(TGroupExample example);

    @DeleteProvider(type = TGroupSqlProvider.class, method = "deleteByExample")
    int deleteByExample(TGroupExample example);

    @Delete({
            "delete from t_group",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into t_group (group_name, owner, ",
            "update_time, create_time)",
            "values (#{groupName,jdbcType=VARCHAR}, #{owner,jdbcType=INTEGER}, ",
            "#{updateTime,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TGroup record);

    @InsertProvider(type = TGroupSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TGroup record);

    @SelectProvider(type = TGroupSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "group_name", property = "groupName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "owner", property = "owner", jdbcType = JdbcType.INTEGER),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT)
    })
    List<TGroup> selectByExample(TGroupExample example);

    @Select({
            "select",
            "id, group_name, owner, update_time, create_time",
            "from t_group",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "group_name", property = "groupName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "owner", property = "owner", jdbcType = JdbcType.INTEGER),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT)
    })
    TGroup selectByPrimaryKey(Long id);

    @UpdateProvider(type = TGroupSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TGroup record, @Param("example") TGroupExample example);

    @UpdateProvider(type = TGroupSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") TGroup record, @Param("example") TGroupExample example);

    @UpdateProvider(type = TGroupSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TGroup record);

    @Update({
            "update t_group",
            "set group_name = #{groupName,jdbcType=VARCHAR},",
            "owner = #{owner,jdbcType=INTEGER},",
            "update_time = #{updateTime,jdbcType=BIGINT},",
            "create_time = #{createTime,jdbcType=BIGINT}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TGroup record);
}