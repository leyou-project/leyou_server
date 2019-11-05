/*
 * 作者：刘时明
 * 时间：2019/11/2-11:53
 * 作用：
 */
package com.leyou.goods.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.leyou.domain.goods.Goods;

public interface GoodsService
{
    IPage<Goods> getGoodsList(int page, int size);

    Goods getGoodsById(long id);
}
