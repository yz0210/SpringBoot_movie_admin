package com.example.SpringBoot_movie_admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.MovieType;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.mapper.MovieTypeMapper;
import com.example.SpringBoot_movie_admin.service.MovieTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MovieTypeServiceImpl extends ServiceImpl<MovieTypeMapper, MovieType> implements MovieTypeService {

    @Resource
    private MovieTypeMapper movieTypeMapper;

    @Override
    public List<ToolTree> getTypeTreeList() {
        List<MovieType> movieTypeList = movieTypeMapper.selectList(null);
        List<ToolTree> list=new ArrayList<>();
        for(MovieType movieType:movieTypeList){
            ToolTree typeTree =new ToolTree();
            if(movieType.getCid()==0){
                typeTree.setId(movieType.getId());
                typeTree.setAuthName(movieType.getType());
                typeTree.setChildren(getTypeChildTree(movieTypeList,movieType.getId()));
                list.add(typeTree);
            }
        }
        return list;
    }

    @Override
    public List<ToolTree> getTypeChildTree(List<MovieType> list, Integer id) {
        List<ToolTree> list2=new ArrayList<>();
        for(MovieType movieType:list){
            ToolTree typeTree =new ToolTree(null,null);
            if(Objects.equals(movieType.getCid(), id)){
                typeTree.setId(movieType.getId());
                typeTree.setAuthName(movieType.getType());
                //typeTree.setChildren(getTypeChildTree(list,movieType.getId()));
                list2.add(typeTree);
                //System.out.println(typeTree.toString());
            }

        }

        return list2;
    }
}
