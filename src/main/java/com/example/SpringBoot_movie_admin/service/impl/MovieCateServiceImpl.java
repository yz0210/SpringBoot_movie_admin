package com.example.SpringBoot_movie_admin.service.impl;

import com.example.SpringBoot_movie_admin.entity.BaseEntity;
import com.example.SpringBoot_movie_admin.entity.movieCates.*;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.mapper.movieCateMappers.*;
import com.example.SpringBoot_movie_admin.service.MovieCateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yang-sir
 * @date: 2023/3/27 20:02
 * @projectName: SpringBoot_movie_admin
 * @version: 1.0
 */
@Service
public class MovieCateServiceImpl implements MovieCateService {
    @Resource
    private MovieAgeMapper movieAgeMapper;
    @Resource
    private MovieAreaMapper movieAreaMapper;
    @Resource
    private MovieTypeMapper movieTypeMapper;
    @Resource
    private MovieSortMapper movieSortMapper;
    @Resource
    private MovieTagMapper movieTagMapper;


    @Override
    public List<ToolTree> getCateTree() {

        List<ToolTree> list =new ArrayList<>();
        //电影类型树
        List<MovieType> movieTypeList = movieTypeMapper.selectList(null);
        List<BaseEntity>list1=new ArrayList<>(movieTypeList);
        ToolTree tree1 =new ToolTree(1,"类型",null,null,0,new MovieType().getTree(list1));
        //地区
        List<MovieArea> movieAreaList=movieAreaMapper.selectList(null);
        List<BaseEntity>list2=new ArrayList<>(movieAreaList);
        ToolTree tree2 =new ToolTree(2,"地区",null,null,0,new MovieArea().getTree(list2));
        //年代
        List<MovieAge> movieAgeList=movieAgeMapper.selectList(null);
        List<BaseEntity>list3=new ArrayList<>(movieAgeList);
        ToolTree tree3 =new ToolTree(3,"年代",null,null,0, new MovieAge().getTree(list3));
        //标签
        List<MovieTag> movieTagList=movieTagMapper.selectList(null);
        List<BaseEntity>list4=new ArrayList<>(movieTagList);
        ToolTree tree4 =new ToolTree(4,"标签",null,null,0,  new MovieTag().getTree(list4));
        //排序
        List<MovieSort> movieSortList=movieSortMapper.selectList(null);
        List<BaseEntity>list5=new ArrayList<>(movieSortList);
        ToolTree tree5 =new ToolTree(5,"排序",null,null,0, new MovieSort().getTree(list5));

        list.add(tree1);list.add(tree2);list.add(tree3);list.add(tree4);list.add(tree5);

        return list;
    }
}
