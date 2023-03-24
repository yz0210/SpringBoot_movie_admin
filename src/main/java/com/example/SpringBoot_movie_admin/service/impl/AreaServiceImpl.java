package com.example.SpringBoot_movie_admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.Area;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.mapper.AdminMapper;
import com.example.SpringBoot_movie_admin.mapper.AreaMapper;
import com.example.SpringBoot_movie_admin.service.AreaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {
    @Override
    public List<ToolTree> getAreaTree() {
        return null;
    }

    @Override
    public List<ToolTree> getRightsChildTree(List<Area> list, Integer id) {
        return null;
    }
}
