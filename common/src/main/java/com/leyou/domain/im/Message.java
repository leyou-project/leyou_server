/*
 * 作者：刘时明
 * 时间：2019/11/7-0:18
 * 作用：
 */
package com.leyou.domain.im;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "t_message")
public class Message implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int code;
    private Long toId;
    private Long formId;
    private String title;
    private String content;
    // 状态，1未读，2已读，3删除
    private Integer status;
    private Date updateTime;
    private Date createTime;
}
