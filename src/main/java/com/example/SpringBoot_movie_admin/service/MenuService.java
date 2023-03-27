package com.example.SpringBoot_movie_admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.SpringBoot_movie_admin.entity.MovieMenu;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;

import java.util.List;

public interface MenuService extends IService<MovieMenu> {
    /**
     * 查询菜单列表
     * @return 菜单列表
     */
    List<ToolTree> findMenuTree();


    /**
     * 构建树
     * @return 菜单列表
     */
    List<ToolTree> findMenusNextTree(List<MovieMenu> list, Integer menuId);
}
