/*
 * 作者：刘时明
 * 时间：2019/11/1-22:23
 * 作用：
 */
package com.leyou.domain.user;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@TableName("t_User_details")
public class UserDetails implements Serializable
{
    @Id
    private Long id;
    private Integer uid;
    private Long birth;
    private String phoneArea;
    private String country;
    private String province;
    private String city;
    private Long lastLogin;
    private Long updateTime;
    private Long createTime;
}
