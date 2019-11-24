/**
 * 作者：刘时明
 * 时间：2019/11/2-16:43
 * 作用：
 */
package com.leyou.gateway.config;

import com.leyou.gateway.interceptor.AuthInterceptor;
import com.leyou.gateway.interceptor.BlackListInterceptor;
import com.leyou.gateway.interceptor.LimitInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer
{
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        // 请求黑名单拦截器
        registry.addInterceptor(blackListInterceptor()).addPathPatterns("/**");

        // 限流拦截器
        registry.addInterceptor(limitInterceptor()).addPathPatterns("/**");

        // 权限拦截器
        registry.addInterceptor(authInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public LimitInterceptor limitInterceptor()
    {
        return new LimitInterceptor();
    }

    @Bean
    public AuthInterceptor authInterceptor()
    {
        return new AuthInterceptor();
    }

    @Bean
    public BlackListInterceptor blackListInterceptor()
    {
        return new BlackListInterceptor();
    }
}
