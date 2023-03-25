package com.example.SpringBoot_movie_admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.SpringBoot_movie_admin.entity.Admin;
import com.example.SpringBoot_movie_admin.entity.tool.PageInfo;

import java.io.Serializable;

public interface AdminService extends IService<Admin> {


    Admin getLoginResult(Admin admin);

    PageInfo<Admin> getAdminList(Long pagenum, Long pagesize, String query);

    Admin getFindByIdResult(Serializable id);

    Integer getAddResult(Admin admin);

    Integer getDelResult(int id);

    Integer getUpdateResult(Admin admin);

    Integer getUpdateRoleResult(int uid,int rid);

    Integer getUpdateStatusResult(Integer id,Boolean bool);

}
