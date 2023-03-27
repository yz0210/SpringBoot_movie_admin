package com.example.SpringBoot_movie_admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.SpringBoot_movie_admin.entity.movieCate.MovieType;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;

import java.util.List;

public interface MovieTypeService extends IService<MovieType> {

    List<ToolTree> getTypeTreeList();

    List<ToolTree> getTypeChildTree(List<MovieType> list, Integer id);
}
