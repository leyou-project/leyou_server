/**
 * 作者：刘时明
 * 时间：2019/11/4-19:03
 * 作用：
 */
package com.leyou.im.logic;

import com.leyou.im.server.WebSocketServer;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/ws")
public class SendLogic
{
    @RequestMapping("/socket/push/{cid}")
    public Object pushToWeb(@PathVariable String cid, String message)
    {
        try
        {
            WebSocketServer.sendInfo(message, cid);
        } catch (IOException e)
        {
            e.printStackTrace();
            return cid + "#" + e.getMessage();
        }
        return cid;
    }
}
