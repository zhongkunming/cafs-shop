package com.cafs.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cafs.shop.mapper")
public class ThwApp {

    public static void main(String[] args) {
        SpringApplication.run(ThwApp.class, args);
    }

}
