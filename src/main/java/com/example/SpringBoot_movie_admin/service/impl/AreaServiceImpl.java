package com.example.SpringBoot_movie_admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.BaseEntity;
import com.example.SpringBoot_movie_admin.entity.movieCate.MovieArea;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.mapper.AreaMapper;
import com.example.SpringBoot_movie_admin.service.AreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, MovieArea> implements AreaService {

    @Resource
    private AreaMapper areaMapper;

    @Override
    public List<ToolTree> getAreaTree() {
        List<MovieArea> areaList=areaMapper.selectList(null);
        List<BaseEntity>newLise=new ArrayList<>(areaList);

        return new MovieArea().getTree(newLise);

    }

}
