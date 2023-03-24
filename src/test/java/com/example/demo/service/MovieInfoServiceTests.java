package com.example.demo.service;

import com.example.demo.entity.MovieInfoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieInfoServiceTests {

    @Autowired
    public MovieInfoService service;

    @Test
    public void getMovieInfoList() {
        System.err.println(service);

        /*List<MovieInfoEntity> list = service.getMovieInfoList(num, size);
        System.err.println("count=" + list.size());
        for (MovieInfoEntity item : list) {
            System.out.println(item);
        }*/
    }
}
