/*
 * 作者：刘时明
 * 时间：2019/11/2-11:11
 * 作用：
 */
package com.leyou.user.repository;

import com.leyou.user.domin.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    User findUserByUserNameAndPassword(String userName, String password);
}
