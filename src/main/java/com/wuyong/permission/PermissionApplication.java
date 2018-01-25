package com.wuyong.permission;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.wuyong.permission.mapper")
public class PermissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PermissionApplication.class, args);
    }
}
