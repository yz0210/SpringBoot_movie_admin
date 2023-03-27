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
import java.util.Objects;

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
        //new RoleRights().getTree(newLise);
        //System.out.println(new RoleRights().getTree(newLise));

       /* List<ToolTree> list1=new ArrayList<>();
        for(RoleRights right:list){
            ToolTree rightsTree =new ToolTree();
            if(right.getLevel()==0){
                rightsTree.setId(right.getId());
                rightsTree.setLabel(right.getLabel());
                rightsTree.setChildren(getRightsChildTree(list,right.getId()));
                list1.add(rightsTree);
            }
        }
        System.out.println(list1);
        return list1;*/
        return new RoleRights().getTree(newLise);
    }

    @Override
    public List<ToolTree> getRightsChildTree(List<RoleRights> list, Integer id) {
        List<ToolTree> list2=new ArrayList<>();
        for(RoleRights right:list){
            ToolTree rightsTree =new ToolTree();
            if(Objects.equals(right.getParentId(), id)){
                rightsTree.setId(right.getId());
                rightsTree.setLabel(right.getLabel());
                rightsTree.setChildren(getRightsChildTree(list,right.getId()));
                list2.add(rightsTree);
            }
        }

        return list2;
    }


}
