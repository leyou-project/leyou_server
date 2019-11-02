/*
 * 作者：刘时明
 * 时间：2019/11/1-22:27
 * 作用：
 */
package com.leyou.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_goods_type")
public class GoodsType implements Serializable
{
    private Long id;
    private Long pid;
    private String typeName;
    private Integer status;
    private Long updateTime;
    private Long createTime;
}
