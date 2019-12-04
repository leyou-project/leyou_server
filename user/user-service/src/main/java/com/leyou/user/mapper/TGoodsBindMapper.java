package com.leyou.user.mapper;

import com.leyou.common.domain.TGoodsBind;
import com.leyou.common.domain.TGoodsBindExample;

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

public interface TGoodsBindMapper
{
    @SelectProvider(type = TGoodsBindSqlProvider.class, method = "countByExample")
    long countByExample(TGoodsBindExample example);

    @DeleteProvider(type = TGoodsBindSqlProvider.class, method = "deleteByExample")
    int deleteByExample(TGoodsBindExample example);

    @Delete({
            "delete from t_goods_bind",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into t_goods_bind (goods_id, field, ",
            "status, update_time, ",
            "create_time)",
            "values (#{goodsId,jdbcType=BIGINT}, #{field,jdbcType=VARCHAR}, ",
            "#{status,jdbcType=BIT}, #{updateTime,jdbcType=INTEGER}, ",
            "#{createTime,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TGoodsBind record);

    @InsertProvider(type = TGoodsBindSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TGoodsBind record);

    @SelectProvider(type = TGoodsBindSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "goods_id", property = "goodsId", jdbcType = JdbcType.BIGINT),
            @Result(column = "field", property = "field", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.INTEGER)
    })
    List<TGoodsBind> selectByExample(TGoodsBindExample example);

    @Select({
            "select",
            "id, goods_id, field, status, update_time, create_time",
            "from t_goods_bind",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "goods_id", property = "goodsId", jdbcType = JdbcType.BIGINT),
            @Result(column = "field", property = "field", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.INTEGER)
    })
    TGoodsBind selectByPrimaryKey(Long id);

    @UpdateProvider(type = TGoodsBindSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TGoodsBind record, @Param("example") TGoodsBindExample example);

    @UpdateProvider(type = TGoodsBindSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") TGoodsBind record, @Param("example") TGoodsBindExample example);

    @UpdateProvider(type = TGoodsBindSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TGoodsBind record);

    @Update({
            "update t_goods_bind",
            "set goods_id = #{goodsId,jdbcType=BIGINT},",
            "field = #{field,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=BIT},",
            "update_time = #{updateTime,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TGoodsBind record);
}