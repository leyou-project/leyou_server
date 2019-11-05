package com.lsm1998.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class FileServerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(FileServerApplication.class, args);
    }
}
