package com.example.SpringBoot_movie_admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.SpringBoot_movie_admin.entity.Right;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;

import java.util.List;

public interface RightService extends IService<Right> {

    List<Right> getRightsList();


    List<ToolTree> getRightsTree(List<Right> list);


    List<ToolTree> getRightsChildTree(List<Right> list, Integer id);
}
