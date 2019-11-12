/**
 * 作者：刘时明
 * 时间：2019/11/5-9:29
 * 作用：
 */
package com.lsm1998.file.service;

import com.lsm1998.file.domian.File;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface FileService
{
    /**
     * 保存文件
     *
     * @param file
     * @return
     */
    File saveFile(File file);

    /**
     * 删除文件
     *
     * @param id
     * @return
     */
    void removeFile(String id);

    /**
     * 根据id获取文件
     *
     * @param id
     * @return
     */
    Optional<File> getFileById(String id);

    /**
     * 分页查询，按上传时间降序
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Page<File> listFilesByPage(int pageIndex, int pageSize);
}