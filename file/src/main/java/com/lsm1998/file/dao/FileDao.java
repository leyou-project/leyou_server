/**
 * 作者：刘时明
 * 时间：2019/11/5-9:28
 * 作用：
 */
package com.lsm1998.file.dao;

import com.lsm1998.file.domian.File;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileDao extends MongoRepository<File, String>
{

}
