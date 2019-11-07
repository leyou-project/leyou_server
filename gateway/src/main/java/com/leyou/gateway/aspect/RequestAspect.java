/**
 * 作者：刘时明
 * 时间：2019/11/5-19:23
 * 作用：
 */
package com.leyou.gateway.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Aspect
public class RequestAspect
{
    // 访问人次
    private AtomicInteger requestCount = new AtomicInteger(0);
    // 访问人数
    private CopyOnWriteArraySet<String> requestUserSet = new CopyOnWriteArraySet<>();

    @AfterReturning("execution(public * com.leyou.gateway.handler.*.*(..))")
    public void requestHandler() throws Throwable
    {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String uid = request.getHeader("uid");
        if (uid != null)
        {
            requestUserSet.add(uid);
        }
        System.out.println("请求路径：" + request.getRequestURI());
        System.out.println("请求人次=" + requestCount.incrementAndGet());
    }
}
