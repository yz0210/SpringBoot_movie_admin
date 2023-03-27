package com.example.SpringBoot_movie_admin.service.movieCatesService;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.SpringBoot_movie_admin.entity.movieCates.MovieTag;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;

import java.util.List;

/**
 * @author: yang-sir
 * @date: 2023/3/27 18:48
 * @projectName: SpringBoot_movie_admin
 * @version: 1.0
 */
public interface MovieTagService extends IService<MovieTag> {

    List<ToolTree> getTagTree();

}
