/*
 * 作者：刘时明
 * 时间：2019/11/8-22:09
 * 作用：
 */
package com.leyou.im.utils;

import com.google.gson.Gson;
import com.leyou.common.domain.TMessage;

public class MessageUtil
{
    private final static Gson gson=new Gson();
    private final static String DECRYPT_TYPE="CBC";

    /**
     * 解密
     * @param publicKey
     * @param msg
     * @return
     */
    public static String encodeMsg(String publicKey,String msg)
    {
        try
        {
            return DESUtil.decrypt(msg, DECRYPT_TYPE, publicKey);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密
     * @param publicKey
     * @param msg
     * @return
     */
    public static String decodeMsg(String publicKey,String msg)
    {
        try
        {
            return DESUtil.encrypt(msg, DECRYPT_TYPE, publicKey);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String msgToStr(TMessage message)
    {
        return gson.toJson(message);
    }

    public static TMessage strToMsg(String str)
    {
        return gson.fromJson(str,TMessage.class);
    }
}