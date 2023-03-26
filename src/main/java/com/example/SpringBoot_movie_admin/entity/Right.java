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
@TableName("role_rights")
public class Right {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private String label;//权限名字
    @TableField("parentId")
    private Integer parentId;
    private String value;//权限路径
    private Integer level;


}
