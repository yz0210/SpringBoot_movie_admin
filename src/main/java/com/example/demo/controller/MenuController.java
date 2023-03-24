package com.example.demo.controller;

import com.example.demo.entity.tool.MenuTree;
import com.example.demo.service.MenuService;
import com.example.demo.util.ResponseResult;
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
    public ResponseResult<List<MenuTree>> getMovieInfoList() {
        // 执行查询
        List<MenuTree> data= menuService.findMenuTree();
        //System.out.println(data);
        return new ResponseResult<>(SUCCESS,"find success!", data);
    }

}
