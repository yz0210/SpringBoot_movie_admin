package com.example.SpringBoot_movie_admin.service.movieCatesService;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.SpringBoot_movie_admin.entity.movieCates.MovieType;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;

import java.util.List;

public interface MovieTypeService extends IService<MovieType> {

    List<ToolTree> getTypeTree();

}
