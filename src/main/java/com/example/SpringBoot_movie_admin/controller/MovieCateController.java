package com.example.SpringBoot_movie_admin.controller;

import com.example.SpringBoot_movie_admin.entity.BaseEntity;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import com.example.SpringBoot_movie_admin.service.MovieCateService;
import com.example.SpringBoot_movie_admin.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("categories")
@CrossOrigin
public class MovieCateController extends BaseController{

    @Resource
    private MovieCateService movieCateService;


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



    @PostMapping("{cateId}/add")
    public ResponseResult<Integer> getaAddCateResult(@PathVariable Integer cateId,@RequestBody BaseEntity baseEntity) {
        // 执行添加
        Integer addFlag= movieCateService.addCate(cateId,baseEntity);
        //System.out.println(cateId+"  "+baseEntity.toString());
        if(addFlag<0){
            return new ResponseResult<>(-1,"find success!", addFlag);
        }
        return new ResponseResult<>(SUCCESS,"find success!", addFlag);
    }

}
