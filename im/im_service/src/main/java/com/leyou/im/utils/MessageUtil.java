/*
 * 作者：刘时明
 * 时间：2019/11/8-22:09
 * 作用：
 */
package com.leyou.im.utils;

import com.google.gson.Gson;
import com.leyou.domain.im.Message;

public class MessageUtil
{
    private static Gson gson=new Gson();

    public static String msgToStr(Message message)
    {
        return gson.toJson(message);
    }

    public static Message strToMsg(String str)
    {
        return gson.fromJson(str,Message.class);
    }
}
