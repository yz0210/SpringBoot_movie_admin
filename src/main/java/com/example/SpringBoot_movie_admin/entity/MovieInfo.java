package com.example.SpringBoot_movie_admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

import java.sql.Date;

@Data
public class MovieInfo {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private String name;
    private String director;
    private String actor;
    private String type;
    private String area;
    private String language;
    private Date startTime;
    private int timeLength;
    private double score;


}
