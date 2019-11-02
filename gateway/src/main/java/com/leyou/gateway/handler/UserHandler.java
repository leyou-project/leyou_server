/**
 * 作者：刘时明
 * 时间：2019/11/2-16:45
 * 作用：
 */
package com.leyou.gateway.handler;

import com.leyou.domain.User;
import com.leyou.user.service.UserService;
import com.leyou.utils.JWTUtil;
import com.leyou.utils.ResultUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserHandler
{
    @Reference(version = "1.0.0")
    private UserService userService;

    @PostMapping("login")
    public Object login(String userName, String password)
    {
        User user = userService.login(userName, password);
        if (user == null)
        {
            return ResultUtil.error("登录失败");
        } else
        {
            User temp = new User();
            String token = JWTUtil.createJWT(user.getUid());
            temp.setHeadImg(user.getHeadImg());
            temp.setNickName(user.getNickName());
            temp.setLevel(user.getLevel());
            temp.setPhone(user.getPhone());
            return ResultUtil.success(0, token, temp);
        }
    }
}
