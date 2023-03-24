package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Right;
import com.example.demo.entity.tool.ToolTree;
import com.example.demo.mapper.RightMapper;

import com.example.demo.service.RightService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RightServiceImpl extends ServiceImpl<RightMapper, Right> implements RightService {

    @Resource
    private RightMapper rightMapper;

    @Override
    public List<Right> getRightsList() {
        QueryWrapper<Right> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("id","authName","Cid","path","level");
        return rightMapper.selectList(queryWrapper);
    }



    @Override
    public List<ToolTree> getRightsTree(List<Right> list) {
        List<ToolTree> list1=new ArrayList<>();
        for(Right right:list){
            ToolTree rightsTree =new ToolTree();
            if(right.getLevel()==0){
                rightsTree.setId(right.getId());
                rightsTree.setAuthName(right.getAuthName());
                rightsTree.setChildren(getRightsChildTree(list,right.getId()));
                list1.add(rightsTree);
            }
        }

        return list1;
    }

    @Override
    public List<ToolTree> getRightsChildTree(List<Right> list, Integer id) {
        List<ToolTree> list2=new ArrayList<>();
        for(Right right:list){
            ToolTree rightsTree =new ToolTree();
            if(Objects.equals(right.getCid(), id)){
                rightsTree.setId(right.getId());
                rightsTree.setAuthName(right.getAuthName());
                rightsTree.setChildren(getRightsChildTree(list,right.getId()));
                list2.add(rightsTree);
            }
        }

        return list2;
    }


}
