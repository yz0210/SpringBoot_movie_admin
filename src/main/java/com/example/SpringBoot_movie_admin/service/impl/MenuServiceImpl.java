package com.example.SpringBoot_movie_admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.Menu;
import com.example.SpringBoot_movie_admin.entity.tool.MenuTree;
import com.example.SpringBoot_movie_admin.mapper.MenuMapper;
import com.example.SpringBoot_movie_admin.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Resource
    private MenuMapper menuMapper;


    @Override
    public List<MenuTree> findMenuTree() {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();//mybatis-plus的查询方法
        //把查询条件加进来也可以传null
        List<Menu> list = menuMapper.selectList(queryWrapper);
        List<MenuTree> menuTreeList = new ArrayList<>();
        for (Menu  menu:list) {
            MenuTree menuTree = new MenuTree();
            if(menu.getCid() == 0){   //如果你的父id是String类型就equals去比较
                BeanUtils.copyProperties(menu, menuTree);
                menuTree.setChildren(findMenusNextTree(list,(menu.getId())));
                menuTreeList.add(menuTree);
            }
        }
        return menuTreeList;
    }


    @Override
    public List<MenuTree> findMenusNextTree(List<Menu> list, Integer menuId) {
        List<MenuTree> list1 = new ArrayList<>();
        for (Menu menu: list) {
            MenuTree menuTree = new MenuTree();
            if(menu.getCid().equals(menuId)){
                BeanUtils.copyProperties(menu,menuTree);
                menuTree.setChildren(findMenusNextTree(list,menu.getId()));
                list1.add(menuTree);
            }
        }
        return list1;
    }
}
