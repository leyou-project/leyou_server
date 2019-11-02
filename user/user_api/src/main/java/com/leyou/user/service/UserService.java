/*
 * 作者：刘时明
 * 时间：2019/11/2-9:01
 * 作用：
 */
package com.leyou.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.leyou.domain.User;

public interface UserService
{
    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    User login(String userName, String password);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 修改用户状态
     *
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    boolean deleteUser(long id);

    /**
     * 用户列表
     *
     * @param page
     * @param size
     * @return
     */
    IPage<User> getUserList(int page, int size);

    /**
     * @return
     */
    User getUser(long id);
}
