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
@TableName("movie_area")
public class Area {

    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private String value;
    private String label;
    private Integer cid;

}
