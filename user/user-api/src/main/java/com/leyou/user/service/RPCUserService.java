/*
 * 作者：刘时明
 * 时间：2019/11/23-22:09
 * 作用：
 */
package com.leyou.user.service;

import com.leyou.common.domain.TUser;
import com.leyou.common.domain.TUserDetails;

public interface RPCUserService
{
    TUser login(String username, String password);

    TUser get(Long id);

    Long register(TUser user, TUserDetails userDetails);
}
