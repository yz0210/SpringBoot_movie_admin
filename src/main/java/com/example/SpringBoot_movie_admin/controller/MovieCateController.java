package com.example.SpringBoot_movie_admin.controller;

import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.service.MovieCateService;
import com.example.SpringBoot_movie_admin.service.movieCatesService.MovieAreaService;
import com.example.SpringBoot_movie_admin.service.movieCatesService.MovieTypeService;
import com.example.SpringBoot_movie_admin.util.ResponseResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("cate")
@CrossOrigin
public class MovieCateController extends BaseController{

    @Resource
    private MovieCateService movieCateService;

    @Resource
    private MovieTypeService movieTypeService;

    @Resource
    private MovieAreaService movieAreaService;

    @GetMapping("tree")
    public ResponseResult<List<ToolTree>> getTypeAndAreaTreeResult() {
        // 执行查询
        List<ToolTree>data=movieCateService.getCateTree();
        if(Objects.isNull(data)){
            return new ResponseResult<>(0,"err!", null);
        }
        // 返回
        return new ResponseResult<>(SUCCESS,"find success!", data);
    }




}
