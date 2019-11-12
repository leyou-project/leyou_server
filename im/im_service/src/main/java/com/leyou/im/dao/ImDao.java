/*
 * 作者：刘时明
 * 时间：2019/11/12-21:54
 * 作用：
 */
package com.leyou.im.dao;

import com.leyou.domain.im.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImDao extends JpaRepository<Message, Long>
{
}
