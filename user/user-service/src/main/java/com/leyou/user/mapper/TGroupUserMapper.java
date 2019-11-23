package com.leyou.user.mapper;

import com.leyou.domain.TGroupUser;
import com.leyou.domain.TGroupUserExample;
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

public interface TGroupUserMapper {
    @SelectProvider(type=TGroupUserSqlProvider.class, method="countByExample")
    long countByExample(TGroupUserExample example);

    @DeleteProvider(type=TGroupUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(TGroupUserExample example);

    @Delete({
        "delete from t_group_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_group_user (uid, group_id, ",
        "update_time, create_time)",
        "values (#{uid,jdbcType=INTEGER}, #{groupId,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(TGroupUser record);

    @InsertProvider(type=TGroupUserSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(TGroupUser record);

    @SelectProvider(type=TGroupUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT)
    })
    List<TGroupUser> selectByExample(TGroupUserExample example);

    @Select({
        "select",
        "id, uid, group_id, update_time, create_time",
        "from t_group_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT)
    })
    TGroupUser selectByPrimaryKey(Long id);

    @UpdateProvider(type=TGroupUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TGroupUser record, @Param("example") TGroupUserExample example);

    @UpdateProvider(type=TGroupUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TGroupUser record, @Param("example") TGroupUserExample example);

    @UpdateProvider(type=TGroupUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TGroupUser record);

    @Update({
        "update t_group_user",
        "set uid = #{uid,jdbcType=INTEGER},",
          "group_id = #{groupId,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TGroupUser record);
}