package com.example.SpringBoot_movie_admin.entity.tool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo<T> {
    private List<T>rows;
    private String query;
    private Long total;
    private Long pagesize;
    private Long pagenum;

}
