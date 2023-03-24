package com.example.SpringBoot_movie_admin.entity.tool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleInfo {
    private Integer id;
    private String name;
    private String detail;
    private String rights;
    private List<ToolTree> children = new ArrayList<>();

}
