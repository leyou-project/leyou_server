/**
 * 作者：刘时明
 * 时间：2019/11/2-16:45
 * 作用：
 */
package com.leyou.gateway.handler;

import com.leyou.domain.TUser;
import com.leyou.user.service.RPCUserService;
import com.leyou.utils.JWTUtil;
import com.leyou.utils.ResultUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserHandler
{
    @Reference(version = "1.0.0")
    private RPCUserService userService;

    @PostMapping("login")
    public Object login(String userName, String password)
    {
        TUser user = userService.login(userName, password);
        if (user == null)
        {
            return ResultUtil.error("登录失败");
        } else
        {
            TUser temp = new TUser();
            String token = JWTUtil.createJWT(user.getUid());
            temp.setHeadImg(user.getHeadImg());
            temp.setNickName(user.getNickName());
            temp.setLevel(user.getLevel());
            temp.setPhone(user.getPhone());
            return ResultUtil.success(0, token, temp);
        }
    }

    @GetMapping("get/{id}")
    public Object get(@PathVariable Long id)
    {
        return ResultUtil.success(userService.get(id));
    }
}
