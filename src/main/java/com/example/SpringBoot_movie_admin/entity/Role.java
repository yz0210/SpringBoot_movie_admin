package com.example.SpringBoot_movie_admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_role")
public class Role {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private String name;
    private String detail;
    private String rights;

}
