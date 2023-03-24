package com.example.demo.controller;

import com.example.demo.entity.MovieInfoEntity;
import com.example.demo.entity.tool.PageInfo;
import com.example.demo.service.MovieInfoService;
import com.example.demo.util.ResponseResult;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("movieInfo")
@CrossOrigin
public class MovieInfoController extends BaseController{
    @Resource
    private MovieInfoService MovieInfoService;

    /**
     * 分页模糊查询
     * @param page
     * @return
     */
    @PostMapping("list")
    public ResponseResult getMovieInfoList(@RequestBody PageInfo page) {
        // 执行查询
        PageInfo<MovieInfoEntity> date = MovieInfoService.getMovieInfoList(page.getPagenum(), page.getPagesize(),page.getQuery());
        // 返回
        return new ResponseResult<>(SUCCESS,"find success!", date);
    }

    /**
     * 通过Id删除
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseResult<List<MovieInfoEntity>> deleteMovieInfo(@PathVariable("id") Integer id) {
        Integer deleteFlag = MovieInfoService.getDeleteResult(id);
        if (deleteFlag <= 0) {
            return new ResponseResult<>("delete err!", null);
        }

        return new ResponseResult<>(SUCCESS,"delete success!", null);

    }






}
