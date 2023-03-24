package com.example.SpringBoot_movie_admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

@Data
@TableName("movie_info")
public class MovieInfoEntity {
    private Integer id;
    private String name;
    private String director;
    private String actor;
    private String type;
    private String area;
    private String language;
    @TableField("startTime")
    private Date startTime;
    @TableField("timeLength")
    private int timeLength;
    private float score;


}
