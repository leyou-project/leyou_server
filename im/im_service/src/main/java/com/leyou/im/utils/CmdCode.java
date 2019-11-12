/**
 * 作者：刘时明
 * 时间：2019/11/6-18:42
 * 作用：
 */
package com.leyou.im.utils;

public class CmdCode
{
    // ping
    public static final int CODE_PING = 1;
    // 消息回执
    public static final int CODE_ACK = 2;
    // 服务端握手返回
    public static final int CODE_HAKE_ACK = 3;
    // 系统通知
    public static final int CODE_NOTIFY_MSG = 4;
    // 私聊
    public static final int CODE_PRIVATE_MSG = 5;
    // 群聊
    public static final int CODE_GROUP_MSG = 6;
    // 广播
    public static final int CODE_BROADCAST=7;
    // 加入群聊请求
    public static final int CODE_JOIN_GROUP = 8;
    // 加入群聊邀请
    public static final int CODE_JOIN_GROUP_INVITE = 9;
}
