/*
 * 作者：刘时明
 * 时间：2019/11/2-10:12
 * 作用：
 */
package com.leyou.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

@Data
@TableName("t_demo")
public class Demo
{
    @TableId(type = AUTO)
    private Long id;
    @TableField
    private String name;
}
