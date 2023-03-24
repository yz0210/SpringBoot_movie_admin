package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieInfoServiceTests {

    @Autowired
    public MovieInfoService service;

    @Test
    public void getMovieInfoList() {
        System.err.println(service);


    }
}
