/**
 * 作者：刘时明
 * 时间：2019/11/5-19:03
 * 作用：
 */
package com.leyou.domain.logs;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@TableName("t_diary")
public class Diary implements Serializable
{
    @Id
    private Long id;
    private Integer loginCount;
    private Integer registerCount;
}
