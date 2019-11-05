/**
 * 作者：刘时明
 * 时间：2019/11/5-9:31
 * 作用：
 */
package com.lsm1998.file.service.impl;

import com.lsm1998.file.dao.FileDao;
import com.lsm1998.file.domian.File;
import com.lsm1998.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FileServiceImpl implements FileService
{
    @Autowired
    private FileDao fileDao;

    @Override
    public File saveFile(File file)
    {
        return fileDao.save(file);
    }

    @Override
    public void removeFile(String id)
    {
        fileDao.deleteById(id);
    }

    @Override
    public Optional<File> getFileById(String id)
    {
        return fileDao.findById(id);
    }

    @Override
    public Page<File> listFilesByPage(int pageIndex, int pageSize)
    {
        Sort sort = Sort.by(Sort.Direction.DESC, "uploadDate");
        Pageable page = PageRequest.of(pageIndex, pageSize, sort);
        return fileDao.findAll(page);
    }
}
