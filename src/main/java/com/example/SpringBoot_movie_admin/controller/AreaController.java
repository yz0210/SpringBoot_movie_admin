package com.example.SpringBoot_movie_admin.controller;

import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.service.AreaService;
import com.example.SpringBoot_movie_admin.util.ResponseResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("area")
@CrossOrigin
public class AreaController extends BaseController{

    @Resource
    private AreaService areaService;

    @GetMapping("tree")
    public ResponseResult<List<ToolTree>> getAreaTree() {
        // 执行查询
        List<ToolTree> data = areaService.getAreaTree();
        if(Objects.isNull(data)){
            return new ResponseResult<>(0,"err!", null);
        }
        // 返回
        return new ResponseResult<>(SUCCESS,"find success!", data);
    }

}
