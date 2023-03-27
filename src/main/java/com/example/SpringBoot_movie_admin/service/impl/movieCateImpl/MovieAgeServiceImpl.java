package com.example.SpringBoot_movie_admin.service.impl.movieCateImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.BaseEntity;
import com.example.SpringBoot_movie_admin.entity.movieCates.MovieAge;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.mapper.movieCateMappers.MovieAgeMapper;
import com.example.SpringBoot_movie_admin.service.movieCatesService.MovieAgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yang-sir
 * @date: 2023/3/27 18:53
 * @projectName: SpringBoot_movie_admin
 * @version: 1.0
 */
@Service
public class MovieAgeServiceImpl extends ServiceImpl<MovieAgeMapper, MovieAge> implements MovieAgeService {

    @Resource
    private MovieAgeMapper movieAgeMapper;

    @Override
    public List<ToolTree> getAgeTree() {

        List<MovieAge> movieAgeList=movieAgeMapper.selectList(null);
        List<BaseEntity>newList=new ArrayList<>(movieAgeList);
        return new MovieAge().getTree(newList);

    }

}
