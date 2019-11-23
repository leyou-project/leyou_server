package com.leyou.user.mapper;

import com.leyou.domain.TGoodsStyle;
import com.leyou.domain.TGoodsStyleExample;
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

public interface TGoodsStyleMapper {
    @SelectProvider(type=TGoodsStyleSqlProvider.class, method="countByExample")
    long countByExample(TGoodsStyleExample example);

    @DeleteProvider(type=TGoodsStyleSqlProvider.class, method="deleteByExample")
    int deleteByExample(TGoodsStyleExample example);

    @Delete({
        "delete from t_goods_style",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_goods_style (field, stock, ",
        "status, bind_id, update_time, ",
        "create_time)",
        "values (#{field,jdbcType=VARCHAR}, #{stock,jdbcType=INTEGER}, ",
        "#{status,jdbcType=BIT}, #{bindId,jdbcType=BIGINT}, #{updateTime,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(TGoodsStyle record);

    @InsertProvider(type=TGoodsStyleSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(TGoodsStyle record);

    @SelectProvider(type=TGoodsStyleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="field", property="field", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="bind_id", property="bindId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.INTEGER)
    })
    List<TGoodsStyle> selectByExample(TGoodsStyleExample example);

    @Select({
        "select",
        "id, field, stock, status, bind_id, update_time, create_time",
        "from t_goods_style",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="field", property="field", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="bind_id", property="bindId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.INTEGER)
    })
    TGoodsStyle selectByPrimaryKey(Long id);

    @UpdateProvider(type=TGoodsStyleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TGoodsStyle record, @Param("example") TGoodsStyleExample example);

    @UpdateProvider(type=TGoodsStyleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TGoodsStyle record, @Param("example") TGoodsStyleExample example);

    @UpdateProvider(type=TGoodsStyleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TGoodsStyle record);

    @Update({
        "update t_goods_style",
        "set field = #{field,jdbcType=VARCHAR},",
          "stock = #{stock,jdbcType=INTEGER},",
          "status = #{status,jdbcType=BIT},",
          "bind_id = #{bindId,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TGoodsStyle record);
}