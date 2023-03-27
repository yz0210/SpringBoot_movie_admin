package com.example.SpringBoot_movie_admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.SpringBoot_movie_admin.entity.RoleRights;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;

import java.util.List;

public interface RightService extends IService<RoleRights> {

    List<RoleRights> getRightsList();


    List<ToolTree> getRightsTree(List<RoleRights> list);


    List<ToolTree> getRightsChildTree(List<RoleRights> list, Integer id);
}
