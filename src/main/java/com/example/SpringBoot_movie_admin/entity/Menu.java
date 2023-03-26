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
@TableName("movie_menu")
public class Menu  {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    @TableField("parentId")
    private Integer parentId;
    private String label;//目录的名字
    private String value;//目录指向的路径

}
