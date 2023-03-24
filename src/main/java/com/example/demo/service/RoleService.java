package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Role;
import com.example.demo.entity.tool.RoleInfo;


import java.util.List;

public interface RoleService extends IService<Role> {

    List<RoleInfo> getRoleList();


    Integer updateRoleRights(Integer roleId,String IdStr);

    Integer deleteRoleRights(Integer roleId,Integer rightId);


}
