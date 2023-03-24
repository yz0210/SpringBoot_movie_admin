package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.MovieType;
import com.example.demo.entity.tool.ToolTree;

import java.util.List;

public interface MovieTypeService extends IService<MovieType> {

    List<ToolTree> getTypeTreeList();

    List<ToolTree> getTypeChildTree(List<MovieType> list, Integer id);
}
