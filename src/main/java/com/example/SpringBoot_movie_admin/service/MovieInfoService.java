package com.example.SpringBoot_movie_admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.SpringBoot_movie_admin.entity.MovieInfo;
import com.example.SpringBoot_movie_admin.entity.tool.PageInfo;

public interface MovieInfoService extends IService<MovieInfo> {

    PageInfo<MovieInfo> getMovieInfoList(Long pagenum, Long pagesize, String query);


    Integer getDeleteResult(Integer id);

    Integer getAddResult(MovieInfo movieInfo);


}
