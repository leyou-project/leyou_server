/**
 * 作者：刘时明
 * 时间：2019/11/2-16:08
 * 作用：
 */
package com.leyou.utils;

import org.springframework.util.DigestUtils;

import java.util.UUID;

public class MD5Util
{
    public static final int SALT_LEN = 10;

    public static String md5(String str)
    {
        String md5 = DigestUtils.md5DigestAsHex(str.getBytes());
        return md5;
    }

    public static String salt()
    {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, SALT_LEN);
    }

    public static String password(String password, String salt)
    {
        if (password.length() < 10)
        {
            return md5(password);
        }
        char[] charArr = new char[password.length() + salt.length()];
        int index = 0;
        for (int i = 0; i < password.length(); i++)
        {
            if (i % 2 == 0 && i <= 10)
            {
                charArr[index++] = salt.charAt(i);
            } else
            {
                charArr[index++] = password.charAt(i);
            }
        }
        return md5(new String(charArr));
    }
}
