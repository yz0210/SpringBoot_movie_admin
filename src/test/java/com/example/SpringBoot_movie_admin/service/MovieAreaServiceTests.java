package com.example.SpringBoot_movie_admin.service;

import com.example.SpringBoot_movie_admin.service.movieCatesService.MovieAreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieAreaServiceTests {

    @Resource
    private MovieAreaService areaService;

    @Test
    public void getAreaTreeTest(){

        System.out.println(areaService.getAreaTree());

    }


}
