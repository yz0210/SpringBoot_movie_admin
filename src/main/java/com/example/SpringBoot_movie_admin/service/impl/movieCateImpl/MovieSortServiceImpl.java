package com.example.SpringBoot_movie_admin.service.impl.movieCateImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.BaseEntity;
import com.example.SpringBoot_movie_admin.entity.movieCates.MovieSort;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.mapper.movieCateMappers.MovieSortMapper;
import com.example.SpringBoot_movie_admin.service.movieCatesService.MovieSortService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yang-sir
 * @date: 2023/3/27 18:59
 * @projectName: SpringBoot_movie_admin
 * @version: 1.0
 */
@Service
public class MovieSortServiceImpl extends ServiceImpl<MovieSortMapper, MovieSort> implements MovieSortService {

    @Resource
    private MovieSortMapper movieSortMapper;

    @Override
    public List<ToolTree> getSortTree() {
        List<MovieSort> movieSortList=movieSortMapper.selectList(null);
        List<BaseEntity>newList=new ArrayList<>(movieSortList);

        return new MovieSort().getTree(newList);
    }
}
