package com.example.SpringBoot_movie_admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.SpringBoot_movie_admin.entity.MovieMenu;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;

import java.util.List;

public interface MenuService extends IService<MovieMenu> {

    List<ToolTree> getMenuTree();


}
