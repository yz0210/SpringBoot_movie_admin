package com.example.demo.mapper;

import com.example.demo.entity.MovieInfoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieInfoMapperTests {

    @Autowired
    public MovieInfoMapper mapper;

    @Test
    public void findList() {
       /* System.err.println(mapper);

        List<MovieInfoEntity> list = mapper.selectList();
        System.err.println("count=" + list.size());
        for (MovieInfoEntity item : list) {
            System.out.println(item);
        }*/
    }
}
