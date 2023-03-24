package com.example.demo.controller;

import com.example.demo.entity.MovieInfoEntity;
import com.example.demo.entity.tool.PageInfo;
import com.example.demo.service.MovieInfoService;
import com.example.demo.util.ResponseResult;
import org.apache.ibatis.jdbc.Null;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("movieInfo")
@CrossOrigin
public class MovieInfoController extends BaseController{
    @Resource
    private MovieInfoService MovieInfoService;



    @PostMapping("list")
    public ResponseResult<PageInfo<MovieInfoEntity>> getMovieInfoList(@RequestBody PageInfo<Null> page) {
        // 执行查询
        PageInfo<MovieInfoEntity> date = MovieInfoService.getMovieInfoList(page.getPagenum(), page.getPagesize(),page.getQuery());
        // 返回
        return new ResponseResult<>(SUCCESS,"find success!", date);
    }



    @DeleteMapping(value = "/{id}")
    public ResponseResult<Integer> deleteMovieInfo(@PathVariable("id") Integer id) {
        Integer deleteFlag = MovieInfoService.getDeleteResult(id);
        if (deleteFlag <= 0) {
            return new ResponseResult<>("delete err!", deleteFlag);
        }

        return new ResponseResult<>(SUCCESS,"delete success!", deleteFlag);

    }






}
