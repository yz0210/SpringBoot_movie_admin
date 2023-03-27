package com.example.SpringBoot_movie_admin.controller;

import com.example.SpringBoot_movie_admin.entity.MovieAdmin;
import com.example.SpringBoot_movie_admin.entity.tool.PageInfo;
import com.example.SpringBoot_movie_admin.entity.Role;
import com.example.SpringBoot_movie_admin.service.AdminService;
import com.example.SpringBoot_movie_admin.util.ResponseResult;
import org.apache.ibatis.jdbc.Null;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("user")
@CrossOrigin
public class AdminController extends BaseController{

    @Resource
    private AdminService adminService;

    /**
     *登录
     * @RequestBody  AdminEntity admin
     * @return new ResponseResult<>()
     */
    @PostMapping(value = "login")
    private ResponseResult<MovieAdmin> getLoginResult(@RequestBody MovieAdmin admin){
        MovieAdmin data=adminService.getLoginResult(admin);
        if(Objects.isNull(data)){
            return new ResponseResult<>(0,"login err!", null);
        }
        return new ResponseResult<>(SUCCESS,"login success!",data);
    }

    /**
     * id查询用户信息
     * @PathVariable id
     * @return new ResponseResult<>()
     */
    @GetMapping(value = "find/{id}")
    private ResponseResult<MovieAdmin> getFindByIdResult(@PathVariable(value = "id") Serializable id){
        MovieAdmin data=adminService.getFindByIdResult(id);
        if(Objects.isNull(data)){
            return new ResponseResult<>(0,"err!", null);
        }
        return new ResponseResult<>(SUCCESS,"success!",data);
    }

    /**
     *分页模糊查询
     * @RequestBody page
     * @return new ResponseResult<>()
     */
    @PostMapping("show")
    public ResponseResult<PageInfo<MovieAdmin>> getAdminListResult(@RequestBody PageInfo<Null> page) {
        // 执行查询
        PageInfo<MovieAdmin> data = adminService.getAdminList(page.getPagenum(), page.getPagesize(), page.getQuery());
        if(Objects.isNull(data)){
            return new ResponseResult<>(0,"err!", null);
        }
        return new ResponseResult<>(SUCCESS,"find success!", data);

    }


    @PutMapping(value = "add")
    private ResponseResult<MovieAdmin> getAddResult(@RequestBody MovieAdmin admin){

        Integer resultFlag=adminService.getAddResult(admin);
        if(resultFlag<0){
            return new ResponseResult<>(0,"add err!", null);
        }
        return new ResponseResult<>(SUCCESS,"add success",null);
    }


    @DeleteMapping ("del/{id}")
    private ResponseResult<List<MovieAdmin>> getDelResult(@PathVariable("id") int id){
        //System.out.println(id);
        Integer resultFlag=adminService.getDelResult(id);
        if(resultFlag<0)
            return new ResponseResult<>(0,"del err!", null);
        return new ResponseResult<>(SUCCESS,"del success!",null);
    }


    @PostMapping  ("update")
    private ResponseResult<List<MovieAdmin>> getUpdateResult(@RequestBody MovieAdmin admin){
        //System.out.println(admin);
        Integer resultFlag=adminService.getUpdateResult(admin);
        //System.out.println(resultFlag);
        if(resultFlag<0)
            return new ResponseResult<>("upd err!", null);
        return new ResponseResult<>(SUCCESS,"upd success!",null);
    }

    @PutMapping  ("/{id}/role")
    private ResponseResult<List<MovieAdmin>> getUpdateRoleResult(@RequestBody Role role, @PathVariable int id){

        int flag=adminService.getUpdateRoleResult(id,role.getId());
        if(flag<=0)
            return new ResponseResult<>(0,"upd err!",null);
        return new ResponseResult<>(SUCCESS,"upd success!",null);
    }

    @PutMapping  ("/{id}/state/{mgState}")
    private ResponseResult<List<MovieAdmin>> getUpdateStatusResult(@PathVariable int id, @PathVariable Boolean mgState){

        int flag=adminService.getUpdateStatusResult(id,mgState);
        if(flag<=0)
            return new ResponseResult<>(0,"upd err!",null);
        return new ResponseResult<>(SUCCESS,"upd success!",null);
    }





}
