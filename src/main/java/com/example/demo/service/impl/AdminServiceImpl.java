package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.AdminEntity;
import com.example.demo.entity.tool.PageInfo;
import com.example.demo.entity.Role;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminEntity> implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    RoleMapper roleMapper ;


    @Override
    public AdminEntity getLoginResult(AdminEntity admin) {
        return adminMapper.adminLogin(admin);
    }


    @Override
    public PageInfo<AdminEntity> getAdminList(Long pagenum,Long pagesize,String query) {
        //System.out.println(query);
        Page<AdminEntity> page = new Page<>(pagenum, pagesize);

        LambdaQueryWrapper<AdminEntity> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.like(!query.isEmpty(),AdminEntity::getUserName,query);

        Page<AdminEntity> page1 = page(page, queryWrapper);

        List<AdminEntity> rows = page1.getRecords();
        Long total=page1.getTotal();

        //PageInfo<AdminEntity> pageInfo=new PageInfo<AdminEntity>(rows,query,total,pagenum,pagesize);

        return new PageInfo<>(rows,query,total,pagenum,pagesize);


    }

    @Override
    public AdminEntity getFindByIdResult(Serializable id) {
        return adminMapper.selectById(id);
    }

    @Override
    public Integer getAddResult(AdminEntity admin) {
        return adminMapper.addUser(admin);
    }

    @Override
    public Integer getDelResult(int id) {
        return adminMapper.delUser(id);
    }

    @Override
    public Integer getUpdateResult(AdminEntity admin) {
        return adminMapper.updateById(admin);
    }

    @Override
    public Integer getUpdateRoleResult(int uid, int rid) {

        Role role=roleMapper.selectById(rid);
        //System.out.println(role);

        String name=role.getName();

        UpdateWrapper<AdminEntity> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",uid)
                     .set("role_name",name);

        return adminMapper.update(new AdminEntity(),updateWrapper);
    }

    @Override
    public Integer getUpdateStatusResult(Integer id,Boolean bool) {
        UpdateWrapper<AdminEntity> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",id)
                .set("mg_state",bool);
        return adminMapper.update(new AdminEntity(),updateWrapper);
    }


}
