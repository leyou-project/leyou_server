/*
 * 作者：刘时明
 * 时间：2019/11/4-23:11
 * 作用：
 */
package com.leyou.domain.im;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "t_group")
public class Group
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date created;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    @JoinTable(name = "t_user_group", joinColumns = {@JoinColumn(name = "group_id")}
            , inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> userList;
}
