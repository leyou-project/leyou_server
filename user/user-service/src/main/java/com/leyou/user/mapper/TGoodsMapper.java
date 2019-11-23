package com.leyou.user.mapper;

import com.leyou.domain.TGoods;
import com.leyou.domain.TGoodsExample;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface TGoodsMapper
{
    @SelectProvider(type = TGoodsSqlProvider.class, method = "countByExample")
    long countByExample(TGoodsExample example);

    @DeleteProvider(type = TGoodsSqlProvider.class, method = "deleteByExample")
    int deleteByExample(TGoodsExample example);

    @Delete({
            "delete from t_goods",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into t_goods (goods_name, cover_url, ",
            "goods_type, status, update_time, ",
            "create_time)",
            "values (#{goodsName,jdbcType=VARCHAR}, #{coverUrl,jdbcType=VARCHAR}, ",
            "#{goodsType,jdbcType=BIGINT}, #{status,jdbcType=BIT}, #{updateTime,jdbcType=INTEGER}, ",
            "#{createTime,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TGoods record);

    @InsertProvider(type = TGoodsSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TGoods record);

    @SelectProvider(type = TGoodsSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "goods_name", property = "goodsName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cover_url", property = "coverUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "goods_type", property = "goodsType", jdbcType = JdbcType.BIGINT),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.INTEGER)
    })
    List<TGoods> selectByExample(TGoodsExample example);

    @Select({
            "select",
            "id, goods_name, cover_url, goods_type, status, update_time, create_time",
            "from t_goods",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "goods_name", property = "goodsName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cover_url", property = "coverUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "goods_type", property = "goodsType", jdbcType = JdbcType.BIGINT),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.INTEGER)
    })
    TGoods selectByPrimaryKey(Long id);

    @UpdateProvider(type = TGoodsSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TGoods record, @Param("example") TGoodsExample example);

    @UpdateProvider(type = TGoodsSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") TGoods record, @Param("example") TGoodsExample example);

    @UpdateProvider(type = TGoodsSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TGoods record);

    @Update({
            "update t_goods",
            "set goods_name = #{goodsName,jdbcType=VARCHAR},",
            "cover_url = #{coverUrl,jdbcType=VARCHAR},",
            "goods_type = #{goodsType,jdbcType=BIGINT},",
            "status = #{status,jdbcType=BIT},",
            "update_time = #{updateTime,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TGoods record);
}