package com.example.SpringBoot_movie_admin.service.impl.movieCateImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.BaseEntity;
import com.example.SpringBoot_movie_admin.entity.movieCates.MovieArea;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.mapper.movieCateMappers.MovieAreaMapper;
import com.example.SpringBoot_movie_admin.service.movieCatesService.MovieAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class MovieAreaServiceImpl extends ServiceImpl<MovieAreaMapper, MovieArea> implements MovieAreaService {
    @Resource
    private MovieAreaMapper areaMapper;

    @Override
    public List<ToolTree> getAreaTree() {
        List<MovieArea> movieAreaList=areaMapper.selectList(null);
        List<BaseEntity>newList=new ArrayList<>(movieAreaList);

        return new MovieArea().getTree(newList);

    }

}
