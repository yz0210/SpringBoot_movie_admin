package com.example.SpringBoot_movie_admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.SpringBoot_movie_admin.entity.Area;
import com.example.SpringBoot_movie_admin.entity.Right;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;

import java.util.List;

public interface AreaService extends IService<Area> {

    List<ToolTree> getAreaTree();

    List<ToolTree> getRightsChildTree(List<Area> list, Integer id);

}
