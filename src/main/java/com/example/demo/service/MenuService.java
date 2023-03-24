package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Menu;
import com.example.demo.entity.tool.MenuTree;

import java.util.List;

public interface MenuService extends IService<Menu> {
    /**
     * 查询菜单列表
     * @return 菜单列表
     */
    List<MenuTree> findMenuTree();


    /**
     * 构建树
     * @return 菜单列表
     */
    List<MenuTree> findMenusNextTree(List<Menu> list, Integer menuId);
}
