package com.example.SpringBoot_movie_admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.SpringBoot_movie_admin.entity.Admin;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminMapper extends BaseMapper<Admin> {

   Admin adminLogin(Admin admin);

   Integer addUser(Admin admin);

   Integer delUser(int id);




}
