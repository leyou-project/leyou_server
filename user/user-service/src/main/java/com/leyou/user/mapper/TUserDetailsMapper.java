package com.leyou.user.mapper;

import com.leyou.domain.TUserDetails;
import com.leyou.domain.TUserDetailsExample;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface TUserDetailsMapper
{
    @SelectProvider(type = TUserDetailsSqlProvider.class, method = "countByExample")
    long countByExample(TUserDetailsExample example);

    @DeleteProvider(type = TUserDetailsSqlProvider.class, method = "deleteByExample")
    int deleteByExample(TUserDetailsExample example);

    @Delete({
            "delete from t_user_details",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into t_user_details (uid, birth, ",
            "phone_area, country, ",
            "province, city, ",
            "last_login, public_key, ",
            "update_time, create_time)",
            "values (#{uid,jdbcType=INTEGER}, #{birth,jdbcType=INTEGER}, ",
            "#{phoneArea,jdbcType=CHAR}, #{country,jdbcType=VARCHAR}, ",
            "#{province,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, ",
            "#{lastLogin,jdbcType=INTEGER}, #{publicKey,jdbcType=CHAR}, ",
            "#{updateTime,jdbcType=INTEGER}, #{createTime,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TUserDetails record);

    @InsertProvider(type = TUserDetailsSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TUserDetails record);

    @SelectProvider(type = TUserDetailsSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "uid", property = "uid", jdbcType = JdbcType.INTEGER),
            @Result(column = "birth", property = "birth", jdbcType = JdbcType.INTEGER),
            @Result(column = "phone_area", property = "phoneArea", jdbcType = JdbcType.CHAR),
            @Result(column = "country", property = "country", jdbcType = JdbcType.VARCHAR),
            @Result(column = "province", property = "province", jdbcType = JdbcType.VARCHAR),
            @Result(column = "city", property = "city", jdbcType = JdbcType.VARCHAR),
            @Result(column = "last_login", property = "lastLogin", jdbcType = JdbcType.INTEGER),
            @Result(column = "public_key", property = "publicKey", jdbcType = JdbcType.CHAR),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.INTEGER)
    })
    List<TUserDetails> selectByExample(TUserDetailsExample example);

    @Select({
            "select",
            "id, uid, birth, phone_area, country, province, city, last_login, public_key, ",
            "update_time, create_time",
            "from t_user_details",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "uid", property = "uid", jdbcType = JdbcType.INTEGER),
            @Result(column = "birth", property = "birth", jdbcType = JdbcType.INTEGER),
            @Result(column = "phone_area", property = "phoneArea", jdbcType = JdbcType.CHAR),
            @Result(column = "country", property = "country", jdbcType = JdbcType.VARCHAR),
            @Result(column = "province", property = "province", jdbcType = JdbcType.VARCHAR),
            @Result(column = "city", property = "city", jdbcType = JdbcType.VARCHAR),
            @Result(column = "last_login", property = "lastLogin", jdbcType = JdbcType.INTEGER),
            @Result(column = "public_key", property = "publicKey", jdbcType = JdbcType.CHAR),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.INTEGER)
    })
    TUserDetails selectByPrimaryKey(Long id);

    @UpdateProvider(type = TUserDetailsSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TUserDetails record, @Param("example") TUserDetailsExample example);

    @UpdateProvider(type = TUserDetailsSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") TUserDetails record, @Param("example") TUserDetailsExample example);

    @UpdateProvider(type = TUserDetailsSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TUserDetails record);

    @Update({
            "update t_user_details",
            "set uid = #{uid,jdbcType=INTEGER},",
            "birth = #{birth,jdbcType=INTEGER},",
            "phone_area = #{phoneArea,jdbcType=CHAR},",
            "country = #{country,jdbcType=VARCHAR},",
            "province = #{province,jdbcType=VARCHAR},",
            "city = #{city,jdbcType=VARCHAR},",
            "last_login = #{lastLogin,jdbcType=INTEGER},",
            "public_key = #{publicKey,jdbcType=CHAR},",
            "update_time = #{updateTime,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TUserDetails record);
}