package com.leyou.user.mapper;

import com.leyou.common.domain.TUser;

import java.util.List;

import com.leyou.common.domain.TUserExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface TUserMapper
{
    @SelectProvider(type = TUserSqlProvider.class, method = "countByExample")
    long countByExample(TUserExample example);

    @DeleteProvider(type = TUserSqlProvider.class, method = "deleteByExample")
    int deleteByExample(TUserExample example);

    @Delete({
            "delete from t_user",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into t_user (uid, nick_name, ",
            "user_name, password, ",
            "phone, salt, head_img, ",
            "level, signature, ",
            "status, update_time, ",
            "create_time)",
            "values (#{uid,jdbcType=INTEGER}, #{nickName,jdbcType=VARCHAR}, ",
            "#{userName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
            "#{phone,jdbcType=CHAR}, #{salt,jdbcType=CHAR}, #{headImg,jdbcType=VARCHAR}, ",
            "#{level,jdbcType=INTEGER}, #{signature,jdbcType=VARCHAR}, ",
            "#{status,jdbcType=BIT}, #{updateTime,jdbcType=INTEGER}, ",
            "#{createTime,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TUser record);

    @InsertProvider(type = TUserSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TUser record);

    @SelectProvider(type = TUserSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "uid", property = "uid", jdbcType = JdbcType.INTEGER),
            @Result(column = "nick_name", property = "nickName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "phone", property = "phone", jdbcType = JdbcType.CHAR),
            @Result(column = "salt", property = "salt", jdbcType = JdbcType.CHAR),
            @Result(column = "head_img", property = "headImg", jdbcType = JdbcType.VARCHAR),
            @Result(column = "level", property = "level", jdbcType = JdbcType.INTEGER),
            @Result(column = "signature", property = "signature", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.INTEGER)
    })
    List<TUser> selectByExample(TUserExample example);

    @Select({
            "select",
            "id, uid, nick_name, user_name, password, phone, salt, head_img, level, signature, ",
            "status, update_time, create_time",
            "from t_user",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "uid", property = "uid", jdbcType = JdbcType.INTEGER),
            @Result(column = "nick_name", property = "nickName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "phone", property = "phone", jdbcType = JdbcType.CHAR),
            @Result(column = "salt", property = "salt", jdbcType = JdbcType.CHAR),
            @Result(column = "head_img", property = "headImg", jdbcType = JdbcType.VARCHAR),
            @Result(column = "level", property = "level", jdbcType = JdbcType.INTEGER),
            @Result(column = "signature", property = "signature", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.INTEGER)
    })
    TUser selectByPrimaryKey(Long id);

    @UpdateProvider(type = TUserSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    @UpdateProvider(type = TUserSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    @UpdateProvider(type = TUserSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TUser record);

    @Update({
            "update t_user",
            "set uid = #{uid,jdbcType=INTEGER},",
            "nick_name = #{nickName,jdbcType=VARCHAR},",
            "user_name = #{userName,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=VARCHAR},",
            "phone = #{phone,jdbcType=CHAR},",
            "salt = #{salt,jdbcType=CHAR},",
            "head_img = #{headImg,jdbcType=VARCHAR},",
            "level = #{level,jdbcType=INTEGER},",
            "signature = #{signature,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=BIT},",
            "update_time = #{updateTime,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TUser record);
}