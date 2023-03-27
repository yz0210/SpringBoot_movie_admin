package com.example.SpringBoot_movie_admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.BaseEntity;
import com.example.SpringBoot_movie_admin.entity.MovieMenu;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.mapper.MenuMapper;
import com.example.SpringBoot_movie_admin.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MovieMenu> implements MenuService {

    @Resource
    private MenuMapper menuMapper;


    @Override
    public List<ToolTree> findMenuTree() {
        List<MovieMenu> list = menuMapper.selectList(null);

        List<BaseEntity>newLise=new ArrayList<>(list);
        return new MovieMenu().getTree(newLise);

       /* List<ToolTree> menuTreeList = new ArrayList<>();
        for (MovieMenu menu:list) {
            ToolTree menuTree = new ToolTree();
            if(menu.getParentId() == 0){   //如果你的父id是String类型就equals去比较
                BeanUtils.copyProperties(menu, menuTree);
                menuTree.setChildren(findMenusNextTree(list,(menu.getId())));
                menuTreeList.add(menuTree);
            }
        }
        return menuTreeList;*/
    }


    @Override
    public List<ToolTree> findMenusNextTree(List<MovieMenu> list, Integer id) {
        List<ToolTree> list1 = new ArrayList<>();
        for (MovieMenu menu: list) {
            ToolTree menuTree = new ToolTree();
            if(menu.getParentId().equals(id)){
                BeanUtils.copyProperties(menu,menuTree);
                menuTree.setChildren(findMenusNextTree(list,menu.getId()));
                list1.add(menuTree);
            }
        }
        return list1;
    }
}
