package com.example.demo;

import com.example.demo.entity.AdminEntity;
import com.example.demo.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private AdminService adminService;

   /* @Test
    void contextLoads() {
        List<AdminEntity> test = adminService.test("241769512@qq.com", "18397970658");
        System.out.println(test);
    }*/

}
