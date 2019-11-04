/*
 * 作者：刘时明
 * 时间：2019/11/2-9:29
 * 作用：
 */
package com.leyou.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leyou.domain.user.User;
import com.leyou.user.mapper.UserMapper;
import com.leyou.user.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(timeout = 5000, version = "1.0.0")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String userName, String password)
    {
        Map<String, Object> columnMap = new HashMap<>(2);
        columnMap.put("user_name", userName);
        columnMap.put("password", password);
        List<User> result = userMapper.selectByMap(columnMap);
        if (result.size() == 1)
        {
            return result.get(0);
        }
        return null;
    }

    @Override
    public int register(User user)
    {
        return userMapper.insert(user);
    }

    @Override
    public boolean updateUser(User user)
    {
        return userMapper.updateById(user) == 1;
    }

    @Override
    public boolean deleteUser(long id)
    {
        return userMapper.deleteById(id) == 1;
    }

    @Override
    public IPage<User> getUserList(int page, int size)
    {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        return userMapper.selectPage(new Page().setPages(page).setSize(size), wrapper);
    }

    @Override
    public User getUser(long id)
    {
        return userMapper.selectById(id);
    }
}
