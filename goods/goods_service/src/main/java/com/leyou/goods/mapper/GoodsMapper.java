/*
 * 作者：刘时明
 * 时间：2019/11/2-12:02
 * 作用：
 */
package com.leyou.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leyou.domain.goods.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods>
{

}
