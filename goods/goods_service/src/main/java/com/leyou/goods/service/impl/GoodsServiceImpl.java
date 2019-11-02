/*
 * 作者：刘时明
 * 时间：2019/11/2-12:02
 * 作用：
 */
package com.leyou.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leyou.domain.Goods;
import com.leyou.goods.mapper.GoodsMapper;
import com.leyou.goods.service.GoodsService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(timeout = 5000, version = "1.0.0")
public class GoodsServiceImpl implements GoodsService
{
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public IPage<Goods> getGoodsList(int page, int size)
    {
        QueryWrapper<Goods> wrapper=new QueryWrapper<>();
        goodsMapper.selectPage(new Page().setSize(size).setPages(page),wrapper);
        return null;
    }

    @Override
    public Goods getGoodsById(long id)
    {
        return goodsMapper.selectById(id);
    }
}
