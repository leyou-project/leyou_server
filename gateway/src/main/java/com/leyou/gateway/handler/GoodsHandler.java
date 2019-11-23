/*
 * 作者：刘时明
 * 时间：2019/11/2-21:56
 * 作用：
 */
package com.leyou.gateway.handler;

import com.leyou.goods.service.GoodsService;
import com.leyou.utils.ResultUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goods")
public class GoodsHandler
{
    //@Reference(version = "1.0.0")
    private GoodsService goodsService;

    @GetMapping("get/{id}")
    public Object get(@PathVariable long id)
    {
        return ResultUtil.success(goodsService.getGoodsById(id));
    }

    @GetMapping("get")
    public Object getAll(int page, int size)
    {
        return ResultUtil.success(goodsService.getGoodsList(page, size));
    }
}
