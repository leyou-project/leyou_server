/*
 * 作者：刘时明
 * 时间：2019/11/4-23:06
 * 作用：
 */
package com.leyou.domain.im;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String sign;
    private String status;
    private String avatar;
    private String secretKey;
    private Date created;
}
