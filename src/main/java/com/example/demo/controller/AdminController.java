package com.example.demo.controller;

import com.example.demo.entity.AdminEntity;
import com.example.demo.entity.tool.PageInfo;
import com.example.demo.entity.Role;
import com.example.demo.service.AdminService;
import com.example.demo.util.ResponseResult;
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
    private ResponseResult<AdminEntity> getLoginResult(@RequestBody AdminEntity admin){
        AdminEntity data=adminService.getLoginResult(admin);
        if(Objects.isNull(data)){
            return new ResponseResult<>("login err!", null);
        }
        return new ResponseResult<>(SUCCESS,"login success!",data);
    }

    /**
     * id查询用户信息
     * @PathVariable id
     * @return new ResponseResult<>()
     */
    @GetMapping(value = "find/{id}")
    private ResponseResult<AdminEntity> getFindByIdResult(@PathVariable(value = "id") Serializable id){
        AdminEntity data=adminService.getFindByIdResult(id);
        if(Objects.isNull(data)){
            return new ResponseResult<>("err!", null);
        }
        return new ResponseResult<>(SUCCESS,"success!",data);
    }

    /**
     *分页模糊查询
     * @RequestBody page
     * @return new ResponseResult<>()
     */
    @PostMapping("show")
    public ResponseResult<PageInfo<AdminEntity>> getAdminListResult(@RequestBody PageInfo<Null> page) {
        // 执行查询
        PageInfo<AdminEntity> data = adminService.getAdminList(page.getPagenum(), page.getPagesize(), page.getQuery());
        if(Objects.isNull(data)){
            return new ResponseResult<>(0,"err!", null);
        }
        return new ResponseResult<>(SUCCESS,"find success!", data);

    }


    @PostMapping(value = "add")
    private ResponseResult<AdminEntity> getAddResult(@RequestBody AdminEntity admin){
        Integer resultFlag=adminService.getAddResult(admin);
        if(resultFlag<0){
            return new ResponseResult<>("add err!", null);
        }
        return new ResponseResult<>(SUCCESS,null);
    }


    @DeleteMapping ("del/{id}")
    private ResponseResult<List<AdminEntity>> getDelResult(@PathVariable("id") int id){
        //System.out.println(id);
        Integer resultFlag=adminService.getDelResult(id);
        if(resultFlag<0)
            return new ResponseResult<>("del err!", null);
        return new ResponseResult<>(SUCCESS,"del success!",null);
    }


    @PostMapping  ("update")
    private ResponseResult<List<AdminEntity>> getUpdateResult(@RequestBody AdminEntity admin){
        //System.out.println(admin);
        Integer resultFlag=adminService.getUpdateResult(admin);
        //System.out.println(resultFlag);
        if(resultFlag<0)
            return new ResponseResult<>("upd err!", null);
        return new ResponseResult<>(SUCCESS,"upd success!",null);
    }

    @PutMapping  ("/{id}/role")
    private ResponseResult<List<AdminEntity>> getUpdateRoleResult(@RequestBody Role role, @PathVariable int id){

        int flag=adminService.getUpdateRoleResult(id,role.getId());
        if(flag<=0)
            return new ResponseResult<>(0,"upd err!",null);
        return new ResponseResult<>(SUCCESS,"upd success!",null);
    }

    @PutMapping  ("/{id}/state/{mgState}")
    private ResponseResult<List<AdminEntity>> getUpdateStatusResult( @PathVariable int id,@PathVariable Boolean mgState){

        int flag=adminService.getUpdateStatusResult(id,mgState);
        if(flag<=0)
            return new ResponseResult<>(0,"upd err!",null);
        return new ResponseResult<>(SUCCESS,"upd success!",null);
    }





}
