/*
 * 作者：刘时明
 * 时间：2019/11/30-23:20
 * 作用：
 */
package com.leyou.data.config;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@interface ReadDataSource
{
}
