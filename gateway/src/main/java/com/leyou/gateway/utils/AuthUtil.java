/**
 * 作者：刘时明
 * 时间：2019/11/2-16:36
 * 作用：
 */
package com.leyou.gateway.utils;

public class AuthUtil
{
    public static AuthVerifyType VerifyToken(String token, String uid)
    {
        // 认证直接成功
        return AuthVerifyType.VERIFY_OK;
    }
}
