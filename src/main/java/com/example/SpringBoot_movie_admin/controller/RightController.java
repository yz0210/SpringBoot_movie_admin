package com.example.SpringBoot_movie_admin.controller;


import com.example.SpringBoot_movie_admin.entity.Right;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.service.RightService;
import com.example.SpringBoot_movie_admin.util.ResponseResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("rights")
@CrossOrigin
public class RightController extends BaseController{

    @Resource
    private RightService rightService;

    @GetMapping("list")
    public ResponseResult<List<Right>> getRightList() {
        // 执行查询
        List<Right> data = rightService.getRightsList();
        if(Objects.isNull(data)){
            return new ResponseResult<>(0,"err!", null);
        }
        // 返回
        return new ResponseResult<>(SUCCESS,"find success!", data);
    }

    @GetMapping("tree")
    public ResponseResult<List<ToolTree>> getRightTree() {
        // 执行查询
        List<ToolTree> data = rightService.getRightsTree(rightService.getRightsList());
        if(Objects.isNull(data)){
            return new ResponseResult<>(0,"err!", null);
        }
        // 返回
        return new ResponseResult<>(SUCCESS,"find success!", data);
    }




}
