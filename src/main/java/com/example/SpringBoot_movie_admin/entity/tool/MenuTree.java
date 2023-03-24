package com.example.SpringBoot_movie_admin.entity.tool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuTree {
    private Integer id;
    private Integer cid;
    private String authName;
    private String path;
    private List<MenuTree> children = new ArrayList<>();

}
