package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleInfoServiceTests {

    @Resource
    private RoleService roleService;

    @Test
    public void getRoleInfoList() {

        roleService.getRoleList();

    }


}
