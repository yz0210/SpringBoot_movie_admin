package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.MovieInfoEntity;
import com.example.demo.entity.tool.PageInfo;

public interface MovieInfoService extends IService<MovieInfoEntity> {

    PageInfo<MovieInfoEntity> getMovieInfoList(Long pagenum, Long pagesize,String query);


    Integer getDeleteResult(Integer id);


}
