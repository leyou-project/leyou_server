/**
 * 作者：刘时明
 * 时间：2019/11/5-19:23
 * 作用：
 */
package com.leyou.gateway.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Aspect
public class RequestAspect
{
    private AtomicInteger loginCount = new AtomicInteger(0);

    @Before("execution(public * com.leyou.gateway.handler.*.login(..))")
    public void loginHandler() throws Throwable
    {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("请求路径："+request.getRequestURI());
        System.out.println("当前登录次数：" + loginCount.getAndIncrement());
    }
}
