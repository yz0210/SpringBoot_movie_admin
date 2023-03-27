package com.example.SpringBoot_movie_admin.service.impl.movieCateImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.BaseEntity;
import com.example.SpringBoot_movie_admin.entity.movieCates.MovieType;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.mapper.movieCateMappers.MovieTypeMapper;
import com.example.SpringBoot_movie_admin.service.movieCatesService.MovieTypeService;
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
