package com.example.SpringBoot_movie_admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringBoot_movie_admin.entity.MovieInfo;
import com.example.SpringBoot_movie_admin.entity.tool.PageInfo;
import com.example.SpringBoot_movie_admin.mapper.MovieInfoMapper;
import com.example.SpringBoot_movie_admin.service.MovieInfoService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MovieInfoServiceImpl extends ServiceImpl<MovieInfoMapper, MovieInfo>
        implements MovieInfoService {

    @Resource
    private  MovieInfoMapper movieInfoMapper;

    /**
     * 电影列表分页查询
     * */
    @Override
    public PageInfo<MovieInfo> getMovieInfoList(Long pagenum, Long pagesize, String query) {
        Page<MovieInfo> page = new Page<>(pagenum,pagesize);

        LambdaQueryWrapper<MovieInfo> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.like(!query.isEmpty(), MovieInfo::getName,query);
        Page<MovieInfo> page1 = page(page, queryWrapper);

        List<MovieInfo> rows = page1.getRecords();
        Long total=page1.getTotal();

        return new PageInfo<>(rows,query,total,pagenum,pagesize);

    }


    @Override
    public Integer getDeleteResult(Integer id) {
        return movieInfoMapper.deleteById(id);
    }

    @Override
    public Integer getAddResult(MovieInfo movieInfo) {
        return movieInfoMapper.insert(movieInfo);
    }
}
