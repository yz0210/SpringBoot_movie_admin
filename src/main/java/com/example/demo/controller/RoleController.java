package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.entity.tool.RoleInfo;
import com.example.demo.service.RoleService;
import com.example.demo.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("roles")
@CrossOrigin
public class RoleController extends BaseController{

    @Resource
    private RoleService roleService;

    @GetMapping("list")
    public ResponseResult<List<RoleInfo>> getRoleList() {
        // 执行查询
        List<RoleInfo> data = roleService.getRoleList();
        if(Objects.isNull(data))
            return new ResponseResult<>(0,"err!", null);
        return new ResponseResult<>(SUCCESS,"find success!", data);
    }


    @PostMapping("/{roleId}/rights")
    private ResponseResult<Integer> getUpdateRoleResult(@RequestBody Role role , @PathVariable Integer roleId){

        int flag=roleService.updateRoleRights(roleId,role.getRights());
        if(flag<=0)
            return new ResponseResult<>(0,"upd err!",flag);
        return new ResponseResult<>(SUCCESS,"upd success!",flag);
    }

    @DeleteMapping ("/{roleId}/rights/{rightId}")
    private ResponseResult<Integer> getDelRoleRightResult(@PathVariable Integer roleId,@PathVariable Integer rightId){

        int flag=roleService.deleteRoleRights(roleId,rightId);
        if(flag<=0)
            return new ResponseResult<>(0,"del err!",flag);
        return new ResponseResult<>(SUCCESS,"del success!",flag);
    }

}
