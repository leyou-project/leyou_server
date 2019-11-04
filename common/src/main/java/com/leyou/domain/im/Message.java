/**
 * 作者：刘时明
 * 时间：2019/11/4-8:48
 * 作用：
 */
package com.leyou.domain.im;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_message")
public class Message implements Serializable
{
    private Long formId;
    private Long toId;
    private Integer type;
}
