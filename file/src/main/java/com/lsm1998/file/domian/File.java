/**
 * 作者：刘时明
 * 时间：2019/11/5-9:24
 * 作用：
 */
package com.lsm1998.file.domian;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Data
@Document
public class File
{
    @Id
    private String id;
    private String name;
    private String contentType;
    private long size;
    private Date uploadDate;
    private byte[] content;
    private String path;

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        File fileInfo = (File) obj;
        return Objects.equals(size, fileInfo.size)
                && Objects.equals(name, fileInfo.name)
                && Objects.equals(contentType, fileInfo.contentType)
                && Objects.equals(uploadDate, fileInfo.uploadDate)
                && Objects.equals(id, fileInfo.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, contentType, size, uploadDate, id);
    }

    @Override
    public String toString()
    {
        return "File{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contentType='" + contentType + '\'' +
                ", size=" + size +
                ", uploadDate=" + uploadDate +
                ", content=" + Arrays.toString(content) +
                ", path='" + path + '\'' +
                '}';
    }
}
