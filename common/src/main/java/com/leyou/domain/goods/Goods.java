/*
 * 作者：刘时明
 * 时间：2019/11/2-11:54
 * 作用：
 */
package com.leyou.domain.goods;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@TableName("t_goods")
public class Goods implements Serializable
{
    @Id
    private Long id;
    private String goodsName;
    private String coverUrl;
    private Long goodsType;
    private Integer status;
    private Long updateTime;
    private Long createTime;
}
