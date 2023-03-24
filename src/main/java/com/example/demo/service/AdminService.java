package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.AdminEntity;
import com.example.demo.entity.tool.PageInfo;

import java.io.Serializable;

public interface AdminService extends IService<AdminEntity> {


    AdminEntity getLoginResult(AdminEntity admin);

    PageInfo<AdminEntity> getAdminList(Long pagenum,Long pagesize,String query);

    AdminEntity getFindByIdResult(Serializable id);

    Integer getAddResult(AdminEntity admin);

    Integer getDelResult(int id);

    Integer getUpdateResult(AdminEntity admin);

    Integer getUpdateRoleResult(int uid,int rid);

    Integer getUpdateStatusResult(Integer id,Boolean bool);

}
