package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Right;
import com.example.demo.entity.Role;
import com.example.demo.entity.tool.RoleInfo;
import com.example.demo.mapper.RightMapper;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RightMapper rightMapper;
    @Resource
    private RightServiceImpl rightService;

    @Override
    public List<RoleInfo> getRoleList() {
        List<Role> roleList =roleMapper.selectList(null);
        List<RoleInfo> roleInfoList=new ArrayList();

        for(Role role:roleList){
            RoleInfo roleInfoTree=new RoleInfo();
            BeanUtils.copyProperties(role, roleInfoTree); //加入角色基本信息

            String rightsStr=role.getRights();//获得权限id串
            List<Right> rightList=rightMapper.selectBatchIds(Arrays.asList(rightsStr.split(",")));//获得权限表

            roleInfoTree.setChildren(rightService.getRightsTree(rightList));//加入Child

            roleInfoList.add(roleInfoTree);
        }
        return roleInfoList;
    }

    @Override
    public Integer updateRoleRights(Integer roleId, String IdStr) {
        UpdateWrapper<Role> updateWrapper =new UpdateWrapper<>();
        updateWrapper.eq("id",roleId)
                .set("rights",IdStr);

        return roleMapper.update(null,updateWrapper);
    }


    @Override
    public Integer deleteRoleRights(Integer roleId, Integer rightId) {
        QueryWrapper<Role> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",roleId)
                .select("rights");
        Role role=roleMapper.selectOne(queryWrapper);
        List list=Arrays.asList(role.getRights().split(","));

        List arrList = new ArrayList(list);
        arrList.remove(rightId.toString());
        String newIdStr=String.join(",",arrList);

        return updateRoleRights(roleId,newIdStr);
    }


}
