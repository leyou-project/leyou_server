/**
 * 作者：刘时明
 * 时间：2019/11/2-16:21
 * 作用：权限认证拦截器
 */
package com.leyou.gateway.interceptor;

import com.leyou.gateway.logic.AddersLogic;
import com.leyou.gateway.utils.AuthUtil;
import com.leyou.gateway.utils.RequestUtil;
import com.leyou.common.utils.ResultUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        // 登录请求放行
        if (request.getServletPath().equals("/user/login"))
        {
            return true;
        }
        // 白名单放行
        if (AddersLogic.isWhiteList(RequestUtil.getRemoteHost(request)))
        {
            return true;
        }
        // 请求头获取token和uid
        String token = request.getHeader("token");
        String uid = request.getHeader("uid");
        switch (AuthUtil.VerifyToken(token, uid))
        {
            case VERIFY_OK:
                return true;
            case VERIFY_TIME_OUT:
                response.setContentType("text/json;charset=UTF-8");
                response.getWriter().println(ResultUtil.timeOutResult);
                break;
            default:
                response.setContentType("text/json;charset=UTF-8");
                response.getWriter().println(ResultUtil.errorResult);
                break;
        }
        return false;
    }
}
