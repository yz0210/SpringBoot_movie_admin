package com.example.SpringBoot_movie_admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.Admin;
import com.example.SpringBoot_movie_admin.entity.tool.PageInfo;
import com.example.SpringBoot_movie_admin.entity.Role;
import com.example.SpringBoot_movie_admin.mapper.AdminMapper;
import com.example.SpringBoot_movie_admin.mapper.RoleMapper;
import com.example.SpringBoot_movie_admin.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    RoleMapper roleMapper ;


    @Override
    public Admin getLoginResult(Admin admin) {
        return adminMapper.adminLogin(admin);
    }


    @Override
    public PageInfo<Admin> getAdminList(Long pagenum, Long pagesize, String query) {
        //System.out.println(query);
        Page<Admin> page = new Page<>(pagenum, pagesize);

        LambdaQueryWrapper<Admin> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.like(!query.isEmpty(), Admin::getUserName,query);

        Page<Admin> page1 = page(page, queryWrapper);

        List<Admin> rows = page1.getRecords();
        Long total=page1.getTotal();

        //PageInfo<AdminEntity> pageInfo=new PageInfo<AdminEntity>(rows,query,total,pagenum,pagesize);

        return new PageInfo<>(rows,query,total,pagenum,pagesize);


    }

    @Override
    public Admin getFindByIdResult(Serializable id) {
        return adminMapper.selectById(id);
    }

    @Override
    public Integer getAddResult(Admin admin) {
        return adminMapper.addUser(admin);
    }

    @Override
    public Integer getDelResult(int id) {
        return adminMapper.delUser(id);
    }

    @Override
    public Integer getUpdateResult(Admin admin) {
        return adminMapper.updateById(admin);
    }

    @Override
    public Integer getUpdateRoleResult(int uid, int rid) {

        Role role=roleMapper.selectById(rid);
        //System.out.println(role);

        String name=role.getName();

        UpdateWrapper<Admin> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",uid)
                     .set("role_name",name);

        return adminMapper.update(new Admin(),updateWrapper);
    }

    @Override
    public Integer getUpdateStatusResult(Integer id,Boolean bool) {
        UpdateWrapper<Admin> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",id)
                .set("mg_state",bool);
        return adminMapper.update(new Admin(),updateWrapper);
    }


}
