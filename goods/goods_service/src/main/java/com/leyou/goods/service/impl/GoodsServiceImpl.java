/*
 * 作者：刘时明
 * 时间：2019/11/2-12:02
 * 作用：
 */
package com.leyou.goods.service.impl;

import com.leyou.common.domain.TGoods;
import com.leyou.goods.mapper.GoodsMapper;
import com.leyou.goods.service.GoodsService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(timeout = 5000, version = "1.0.0")
public class GoodsServiceImpl implements GoodsService
{
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<TGoods> getGoodsList(int page, int size)
    {
        return null;
    }

    @Override
    public TGoods getGoodsById(long id)
    {
        return null;
    }
}
