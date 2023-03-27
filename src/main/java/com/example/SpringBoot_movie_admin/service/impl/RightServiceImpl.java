package com.example.SpringBoot_movie_admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.BaseEntity;
import com.example.SpringBoot_movie_admin.entity.RoleRights;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.mapper.RightMapper;

import com.example.SpringBoot_movie_admin.service.RightService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RightServiceImpl extends ServiceImpl<RightMapper, RoleRights> implements RightService {

    @Resource
    private RightMapper rightMapper;

    @Override
    public List<RoleRights> getRightsList() {
        return rightMapper.selectList(null);
    }


    @Override
    public List<ToolTree> getRightsTree(List<RoleRights> list) {

        List<BaseEntity>newLise=new ArrayList<>(list);
        return new RoleRights().getTree(newLise);
    }


}
