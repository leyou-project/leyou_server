/*
 * 作者：刘时明
 * 时间：2019/11/1-22:15
 * 作用：
 */
package com.leyou.user.domin;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table
@TableName("t_user")
public class User implements Serializable
{
    @Id
    private Long id;
    private Integer uid;
    private String userName;
    private String password;
    private String nickName;
    private String phone;
    private String salt;
    private String headImg;
    private int level;
    private String signature;
    private Integer status;
    private Long updateTime;
    private Long createTime;
}
