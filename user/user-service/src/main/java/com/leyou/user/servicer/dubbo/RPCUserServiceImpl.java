/*
 * 作者：刘时明
 * 时间：2019/11/23-22:44
 * 作用：
 */
package com.leyou.user.servicer.dubbo;

import com.leyou.domain.TUser;
import com.leyou.domain.TUserDetails;
import com.leyou.user.service.RPCUserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0", timeout = 5000)
public class RPCUserServiceImpl implements RPCUserService
{
    @Autowired
    private RPCUserService userService;

    @Override
    public TUser login(String username, String password)
    {
        return userService.login(username, password);
    }

    @Override
    public TUser get(Long id)
    {
        return userService.get(id);
    }

    @Override
    public Long register(TUser user, TUserDetails userDetails)
    {
        return userService.register(user, userDetails);
    }
}
