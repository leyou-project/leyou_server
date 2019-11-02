/*
 * 作者：刘时明
 * 时间：2019/11/1-22:27
 * 作用：
 */
package com.leyou.domain;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
public class GoodsType implements Serializable
{
    private Long id;
    private Long pid;
    private String typeName;
    private Integer status;
    private Long updateTime;
    private Long createTime;
}
