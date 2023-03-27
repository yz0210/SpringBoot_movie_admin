package com.example.SpringBoot_movie_admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.SpringBoot_movie_admin.entity.MovieAdmin;
import com.example.SpringBoot_movie_admin.entity.tool.PageInfo;

import java.io.Serializable;

public interface AdminService extends IService<MovieAdmin> {


    MovieAdmin getLoginResult(MovieAdmin admin);

    PageInfo<MovieAdmin> getAdminList(Long pagenum, Long pagesize, String query);

    MovieAdmin getFindByIdResult(Serializable id);

    Integer getAddResult(MovieAdmin admin);

    Integer getDelResult(int id);

    Integer getUpdateResult(MovieAdmin admin);

    Integer getUpdateRoleResult(int uid,int rid);

    Integer getUpdateStatusResult(Integer id,Boolean bool);

}
