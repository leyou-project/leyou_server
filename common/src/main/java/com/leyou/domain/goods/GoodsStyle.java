/*
 * 作者：刘时明
 * 时间：2019/11/3-19:53
 * 作用：
 */
package com.leyou.domain.goods;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@TableName
public class GoodsStyle implements Serializable
{
    @Id
    private Long id;
    private String field;
    private Integer stock;
    private Integer status;
    private Long bindId;
    private Long updateTime;
    private Long createTime;
}
