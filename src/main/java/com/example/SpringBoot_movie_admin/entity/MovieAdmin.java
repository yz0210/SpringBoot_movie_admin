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
public class MovieAdmin {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private String userName;
    private String userPassword;
    private String email;
    private String mobile;
    private String roleName;
    private Boolean mgState;
}
