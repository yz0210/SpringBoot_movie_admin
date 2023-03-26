package com.example.SpringBoot_movie_admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("movie_area")
public class MovieArea {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private String value;//地区的英文名
    private String label;//地区展示的名字
    @TableField("parentId")
    private Integer parentId;

}
