package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Right;
import com.example.demo.entity.tool.ToolTree;

import java.util.List;

public interface RightService extends IService<Right> {

    List<Right> getRightsList();


    List<ToolTree> getRightsTree(List<Right> list);


    List<ToolTree> getRightsChildTree(List<Right> list, Integer id);
}
