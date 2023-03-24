package com.example.demo.entity;

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
@TableName("movie_admin")
public class AdminEntity {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    @TableField("userName")
    private String userName;
    @TableField("userPassword")
    private String userPassword;
    private String email;
    private String mobile;
    @TableField("role_name")
    private String roleName;
    @TableField("mg_state")
    private Boolean mgState;
}
