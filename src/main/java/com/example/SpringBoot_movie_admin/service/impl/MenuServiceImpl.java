package com.example.SpringBoot_movie_admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.BaseEntity;
import com.example.SpringBoot_movie_admin.entity.MovieMenu;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.mapper.MenuMapper;
import com.example.SpringBoot_movie_admin.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MovieMenu> implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<ToolTree> getMenuTree() {
        List<MovieMenu> list = menuMapper.selectList(null);

        List<BaseEntity>newLise=new ArrayList<>(list);
        return new MovieMenu().getTree(newLise);

    }

}
