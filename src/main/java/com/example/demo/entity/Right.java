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
@TableName("role_rights")
public class Right {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    @TableField("authName")
    private String authName;
    private Integer cid;
    //private Integer ccid;
    private String path;
    private Integer level;


}
