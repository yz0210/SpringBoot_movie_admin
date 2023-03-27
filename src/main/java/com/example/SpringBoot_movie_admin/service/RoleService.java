package com.example.SpringBoot_movie_admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.SpringBoot_movie_admin.entity.Role;
import com.example.SpringBoot_movie_admin.entity.tool.RoleInfo;


import java.util.List;

public interface RoleService extends IService<Role> {

    List<RoleInfo> getRoleList();

    Integer updateRoleRights(Integer roleId,String IdStr);

    Integer deleteRoleRights(Integer roleId,Integer rightId);


}
