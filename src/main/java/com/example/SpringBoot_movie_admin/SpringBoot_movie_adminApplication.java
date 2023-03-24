package com.example.SpringBoot_movie_admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.SpringBoot_movie_admin.mapper")
@SpringBootApplication
public class SpringBoot_movie_adminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot_movie_adminApplication.class, args);
    }

}
