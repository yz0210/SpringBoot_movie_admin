package com.example.SpringBoot_movie_admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.BaseEntity;
import com.example.SpringBoot_movie_admin.entity.movieCate.MovieType;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.mapper.MovieTypeMapper;
import com.example.SpringBoot_movie_admin.service.MovieTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieTypeServiceImpl extends ServiceImpl<MovieTypeMapper, MovieType> implements MovieTypeService {

    @Resource
    private MovieTypeMapper movieTypeMapper;

    @Override
    public List<ToolTree> getTypeTree() {
        List<MovieType> movieTypeList = movieTypeMapper.selectList(null);

        List<BaseEntity>newList=new ArrayList<>(movieTypeList);
        return new MovieType().getTree(newList);

    }

}
