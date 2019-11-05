/*
 * 作者：刘时明
 * 时间：2019/11/3-19:51
 * 作用：
 */
package com.leyou.domain.goods;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@TableName("t_goods_bind")
public class GoodBind implements Serializable
{
    @Id
    private Long id;
    private Long goodsId;
    private String field;
    private Integer status;
    private Long updateTime;
    private Long createTime;
}
