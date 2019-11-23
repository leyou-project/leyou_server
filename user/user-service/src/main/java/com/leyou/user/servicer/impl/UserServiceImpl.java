/*
 * 作者：刘时明
 * 时间：2019/11/23-22:43
 * 作用：
 */
package com.leyou.user.servicer.impl;

import com.leyou.domain.TUser;
import com.leyou.domain.TUserDetails;
import com.leyou.domain.TUserExample;
import com.leyou.user.mapper.TUserDetailsMapper;
import com.leyou.user.mapper.TUserMapper;
import com.leyou.user.servicer.UserService;
import com.leyou.utils.MD5Util;
import com.leyou.utils.Snowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private TUserDetailsMapper userDetailsMapper;
    @Autowired
    private Snowflake snowflake;

    @Override
    public TUser login(String username, String password)
    {
        TUserExample example = new TUserExample();
        example.createCriteria().andUserNameEqualTo(username);
        List<TUser> list = userMapper.selectByExample(example);
        if (list.size() == 1)
        {
            TUser user = list.get(0);
            String salt = user.getSalt();
            if (MD5Util.password(user.getPassword(), salt).equals(MD5Util.password(password, salt)))
            {
                return user;
            }
        }
        return null;
    }

    @Override
    public TUser get(Long id)
    {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Long register(TUser user, TUserDetails userDetails)
    {
        user.setId(snowflake.nextId());
        userDetails.setId(user.getId());
        if (userMapper.insert(user) == 1 && userDetailsMapper.insert(userDetails) == 1)
        {
            return user.getId();
        } else
        {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
    }
}
