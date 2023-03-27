package com.example.SpringBoot_movie_admin.controller;

import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.service.MenuService;
import com.example.SpringBoot_movie_admin.util.ResponseResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("menu")
@CrossOrigin
public class MenuController extends BaseController{

    @Resource
    private MenuService menuService;


    @GetMapping
    public ResponseResult<List<ToolTree>> getMovieInfoList() {
        // 执行查询
        List<ToolTree> data= menuService.getMenuTree();
        //System.out.println(data);
        return new ResponseResult<>(SUCCESS,"find success!", data);
    }

}
