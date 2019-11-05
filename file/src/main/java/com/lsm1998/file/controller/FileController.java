/**
 * 作者：刘时明
 * 时间：2019/11/5-9:44
 * 作用：
 */
package com.lsm1998.file.controller;

import com.lsm1998.file.domian.File;
import com.lsm1998.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class FileController
{
    @Autowired
    private FileService fileService;
    @Value("${server.port}")
    private String port;
    @Value("${server.address}")
    private String address;

    /**
     * 获取文件信息
     *
     * @param id
     * @return
     */
    @GetMapping("get/{id}")
    public Object get(@PathVariable String id)
    {
        Optional<File> file = fileService.getFileById(id);
        if (file.isPresent())
        {
            return ResponseEntity.ok().body(file.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File was not fount");
    }

    /**
     * 获取文件信息
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("get/{page}/{size}")
    public Object page(@PathVariable int page, @PathVariable int size)
    {
        Page<File> data = fileService.listFilesByPage(page, size);
        data.getTotalPages();
        Map<String,Object> result=new HashMap<>();
        result.put("code",0);
        result.put("info","ok");
        result.put("data","ok");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File was not fount");
    }

    /**
     * 查看文件
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Object view(@PathVariable String id)
    {
        Optional<File> file = fileService.getFileById(id);
        if (file.isPresent())
        {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "fileName=\"" + file.get().getName() + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, file.get().getContentType())
                    .header(HttpHeaders.CONTENT_LENGTH, file.get().getSize() + "")
                    .header("Connection", "close")
                    .body(file.get().getContent());
        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File was not fount");
        }
    }

    /**
     * 上传单个文件
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Object handleFileUpload(@RequestParam("file") MultipartFile file)
    {
        try
        {
            File f = new File();
            f.setName(file.getOriginalFilename());
            f.setContent(file.getBytes());
            f.setContentType(file.getContentType());
            f.setSize(file.getSize());
            File returnFile = fileService.saveFile(f);
            String path = "http://" + address + ":" + port + "/" + returnFile.getId();
            return ResponseEntity.status(HttpStatus.OK).body(path);
        } catch (IOException e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
