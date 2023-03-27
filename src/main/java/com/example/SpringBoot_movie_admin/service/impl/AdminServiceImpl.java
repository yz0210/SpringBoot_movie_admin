package com.example.SpringBoot_movie_admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.MovieAdmin;
import com.example.SpringBoot_movie_admin.entity.tool.PageInfo;
import com.example.SpringBoot_movie_admin.entity.UserRole;
import com.example.SpringBoot_movie_admin.mapper.AdminMapper;
import com.example.SpringBoot_movie_admin.mapper.RoleMapper;
import com.example.SpringBoot_movie_admin.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, MovieAdmin> implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    RoleMapper roleMapper ;


    @Override
    public MovieAdmin getLoginResult(MovieAdmin admin) {
        return adminMapper.adminLogin(admin);
    }


    @Override
    public PageInfo<MovieAdmin> getAdminList(Long pagenum, Long pagesize, String query) {
        //System.out.println(query);
        Page<MovieAdmin> page = new Page<>(pagenum, pagesize);

        LambdaQueryWrapper<MovieAdmin> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.like(!query.isEmpty(), MovieAdmin::getUserName,query);

        Page<MovieAdmin> page1 = page(page, queryWrapper);

        List<MovieAdmin> rows = page1.getRecords();
        Long total=page1.getTotal();

        //PageInfo<AdminEntity> pageInfo=new PageInfo<AdminEntity>(rows,query,total,pagenum,pagesize);

        return new PageInfo<>(rows,query,total,pagenum,pagesize);

    }

    @Override
    public MovieAdmin getFindByIdResult(Serializable id) {
        return adminMapper.selectById(id);
    }

    @Override
    public Integer getAddResult(MovieAdmin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public Integer getDelResult(int id) {
        return adminMapper.delUser(id);
    }


    @Override
    public Integer getUpdateResult(MovieAdmin admin) {
        return adminMapper.updateById(admin);
    }

    @Override
    public Integer getUpdateRoleResult(int uid, int rid) {

        UserRole role=roleMapper.selectById(rid);
        //System.out.println(role);
        String name=role.getName();
        UpdateWrapper<MovieAdmin> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",uid)
                     .set("role_name",name);
        return adminMapper.update(new MovieAdmin(),updateWrapper);
    }

    @Override
    public Integer getUpdateStatusResult(Integer id,Boolean bool) {
        UpdateWrapper<MovieAdmin> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",id)
                .set("mg_state",bool);
        return adminMapper.update(new MovieAdmin(),updateWrapper);
    }

}
