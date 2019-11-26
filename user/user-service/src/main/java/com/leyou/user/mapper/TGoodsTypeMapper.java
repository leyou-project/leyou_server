package com.leyou.user.mapper;

import com.leyou.common.domain.TGoodsType;
import com.leyou.common.domain.TGoodsTypeExample;

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

public interface TGoodsTypeMapper
{
    @SelectProvider(type = TGoodsTypeSqlProvider.class, method = "countByExample")
    long countByExample(TGoodsTypeExample example);

    @DeleteProvider(type = TGoodsTypeSqlProvider.class, method = "deleteByExample")
    int deleteByExample(TGoodsTypeExample example);

    @Delete({
            "delete from t_goods_type",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into t_goods_type (pid, type_name, ",
            "status, update_time, ",
            "create_time)",
            "values (#{pid,jdbcType=BIGINT}, #{typeName,jdbcType=VARCHAR}, ",
            "#{status,jdbcType=BIT}, #{updateTime,jdbcType=INTEGER}, ",
            "#{createTime,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TGoodsType record);

    @InsertProvider(type = TGoodsTypeSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TGoodsType record);

    @SelectProvider(type = TGoodsTypeSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "pid", property = "pid", jdbcType = JdbcType.BIGINT),
            @Result(column = "type_name", property = "typeName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.INTEGER)
    })
    List<TGoodsType> selectByExample(TGoodsTypeExample example);

    @Select({
            "select",
            "id, pid, type_name, status, update_time, create_time",
            "from t_goods_type",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "pid", property = "pid", jdbcType = JdbcType.BIGINT),
            @Result(column = "type_name", property = "typeName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.INTEGER)
    })
    TGoodsType selectByPrimaryKey(Long id);

    @UpdateProvider(type = TGoodsTypeSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TGoodsType record, @Param("example") TGoodsTypeExample example);

    @UpdateProvider(type = TGoodsTypeSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") TGoodsType record, @Param("example") TGoodsTypeExample example);

    @UpdateProvider(type = TGoodsTypeSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TGoodsType record);

    @Update({
            "update t_goods_type",
            "set pid = #{pid,jdbcType=BIGINT},",
            "type_name = #{typeName,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=BIT},",
            "update_time = #{updateTime,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TGoodsType record);
}