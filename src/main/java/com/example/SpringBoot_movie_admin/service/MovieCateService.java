package com.example.SpringBoot_movie_admin.service;

import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;

import java.util.List;

/**
 * @author: yang-sir
 * @date: 2023/3/27 20:01
 * @projectName: SpringBoot_movie_admin
 * @version: 1.0
 */
public interface MovieCateService {

    List<ToolTree> getCateTree();

}
