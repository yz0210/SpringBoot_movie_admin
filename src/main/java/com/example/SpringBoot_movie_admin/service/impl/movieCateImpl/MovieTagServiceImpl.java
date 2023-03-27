package com.example.SpringBoot_movie_admin.service.impl.movieCateImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.BaseEntity;
import com.example.SpringBoot_movie_admin.entity.movieCates.MovieArea;
import com.example.SpringBoot_movie_admin.entity.movieCates.MovieTag;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.mapper.movieCateMappers.MovieTagMapper;
import com.example.SpringBoot_movie_admin.service.movieCatesService.MovieTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yang-sir
 * @date: 2023/3/27 19:01
 * @projectName: SpringBoot_movie_admin
 * @version: 1.0
 */
@Service
public class MovieTagServiceImpl extends ServiceImpl<MovieTagMapper, MovieTag> implements MovieTagService {

    @Resource
    private MovieTagMapper movieTagMapper;

    @Override
    public List<ToolTree> getTagTree() {

        List<MovieTag> movieTagList=movieTagMapper.selectList(null);
        List<BaseEntity>newList=new ArrayList<>(movieTagList);

        return new MovieTag().getTree(newList);
    }
}
