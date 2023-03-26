package com.example.SpringBoot_movie_admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.SpringBoot_movie_admin.entity.MovieArea;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;

import java.util.List;

public interface AreaService extends IService<MovieArea> {

    List<ToolTree> getAreaTree();

    List<ToolTree> getAreaChildTree(List<MovieArea> list, Integer id);

}
