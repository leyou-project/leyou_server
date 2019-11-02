/*
 * 作者：刘时明
 * 时间：2019/11/2-9:29
 * 作用：
 */
package com.leyou.user.service.impl;

import com.leyou.user.domin.User;
import com.leyou.user.repository.UserRepository;
import com.leyou.user.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service(timeout = 5000, version = "1.0.0")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String userName, String password)
    {
        return userRepository.findUserByUserNameAndPassword(userName, password);
    }

    @Override
    public int register(User user)
    {
        User temp = userRepository.save(user);
        return temp.getUid();
    }

    @Override
    public boolean updateUser(User user)
    {
        return userRepository.save(user) != null;
    }

    @Override
    public boolean deleteUser(long id)
    {
        User user = this.getUser(id).get();
        userRepository.deleteById(id);
        return user != null;
    }

    @Override
    public Page<User> getUserList(int page, int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> getUser(long id)
    {
        return userRepository.findById(id);
    }
}
