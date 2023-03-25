package com.example.SpringBoot_movie_admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.Area;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.mapper.AreaMapper;
import com.example.SpringBoot_movie_admin.service.AreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {

    @Resource
    private AreaMapper areaMapper;

    @Override
    public List<ToolTree> getAreaTree() {
        List<Area> areaList=areaMapper.selectList(null);
        List<ToolTree> list=new ArrayList<>();
        for(Area area:areaList){
            ToolTree areaTree =new ToolTree();
            if(area.getCid()==0){
                areaTree.setId(area.getId());
                areaTree.setAuthName(area.getLabel());
                areaTree.setValue(area.getValue());
                areaTree.setChildren(getAreaChildTree(areaList,area.getId()));
                list.add(areaTree);
            }
        }
        return list;
    }

    @Override
    public List<ToolTree> getAreaChildTree(List<Area> list, Integer id) {
        List<ToolTree> list2=new ArrayList<>();
        for(Area area:list){
            ToolTree areaTree =new ToolTree();
            if(Objects.equals(area.getCid(), id)){
                areaTree.setId(area.getId());
                areaTree.setAuthName(area.getLabel());
                areaTree.setValue(area.getValue());
                areaTree.setChildren(getAreaChildTree(list,area.getId()));
                list2.add(areaTree);
            }
        }
        return list2;
    }
}
