package com.leyou.user.mapper;

import com.leyou.domain.TCart;
import com.leyou.domain.TCartExample;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface TCartMapper
{
    @SelectProvider(type = TCartSqlProvider.class, method = "countByExample")
    long countByExample(TCartExample example);

    @DeleteProvider(type = TCartSqlProvider.class, method = "deleteByExample")
    int deleteByExample(TCartExample example);

    @Delete({
            "delete from t_cart",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into t_cart (user_id, goods_style_id, ",
            "num, sum, update_time, ",
            "create_time)",
            "values (#{userId,jdbcType=BIGINT}, #{goodsStyleId,jdbcType=BIGINT}, ",
            "#{num,jdbcType=INTEGER}, #{sum,jdbcType=INTEGER}, #{updateTime,jdbcType=BIGINT}, ",
            "#{createTime,jdbcType=BIGINT})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TCart record);

    @InsertProvider(type = TCartSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TCart record);

    @SelectProvider(type = TCartSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "goods_style_id", property = "goodsStyleId", jdbcType = JdbcType.BIGINT),
            @Result(column = "num", property = "num", jdbcType = JdbcType.INTEGER),
            @Result(column = "sum", property = "sum", jdbcType = JdbcType.INTEGER),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT)
    })
    List<TCart> selectByExample(TCartExample example);

    @Select({
            "select",
            "id, user_id, goods_style_id, num, sum, update_time, create_time",
            "from t_cart",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "goods_style_id", property = "goodsStyleId", jdbcType = JdbcType.BIGINT),
            @Result(column = "num", property = "num", jdbcType = JdbcType.INTEGER),
            @Result(column = "sum", property = "sum", jdbcType = JdbcType.INTEGER),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT)
    })
    TCart selectByPrimaryKey(Long id);

    @UpdateProvider(type = TCartSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TCart record, @Param("example") TCartExample example);

    @UpdateProvider(type = TCartSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") TCart record, @Param("example") TCartExample example);

    @UpdateProvider(type = TCartSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TCart record);

    @Update({
            "update t_cart",
            "set user_id = #{userId,jdbcType=BIGINT},",
            "goods_style_id = #{goodsStyleId,jdbcType=BIGINT},",
            "num = #{num,jdbcType=INTEGER},",
            "sum = #{sum,jdbcType=INTEGER},",
            "update_time = #{updateTime,jdbcType=BIGINT},",
            "create_time = #{createTime,jdbcType=BIGINT}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TCart record);
}