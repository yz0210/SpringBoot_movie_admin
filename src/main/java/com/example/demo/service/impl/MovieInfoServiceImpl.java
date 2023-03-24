package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.MovieInfoEntity;
import com.example.demo.entity.tool.PageInfo;
import com.example.demo.mapper.MovieInfoMapper;
import com.example.demo.service.MovieInfoService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MovieInfoServiceImpl extends ServiceImpl<MovieInfoMapper,MovieInfoEntity>
        implements MovieInfoService {

    @Resource
    private  MovieInfoMapper movieInfoMapper;

    /**
     * 电影列表分页查询
     * */
    @Override
    public PageInfo<MovieInfoEntity> getMovieInfoList(Long pagenum, Long pagesize,String query) {
        Page<MovieInfoEntity> page = new Page<>(pagenum,pagesize);

        LambdaQueryWrapper<MovieInfoEntity> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.like(!query.isEmpty(),MovieInfoEntity::getName,query);
        Page<MovieInfoEntity> page1 = page(page, queryWrapper);

        List<MovieInfoEntity> rows = page1.getRecords();
        Long total=page1.getTotal();

        return new PageInfo<>(rows,query,total,pagenum,pagesize);

    }


    @Override
    public Integer getDeleteResult(Integer id) {

        return movieInfoMapper.deleteById(id);
    }
}
