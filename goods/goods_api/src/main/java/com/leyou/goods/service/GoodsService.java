/*
 * 作者：刘时明
 * 时间：2019/11/2-11:53
 * 作用：
 */
package com.leyou.goods.service;

import com.leyou.domain.TGoods;

import java.util.List;

public interface GoodsService
{
    List<TGoods> getGoodsList(int page, int size);

    TGoods getGoodsById(long id);
}
