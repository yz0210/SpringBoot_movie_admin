package com.example.SpringBoot_movie_admin.entity.tool;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ToolTree {
    private Integer id;
    private String label;
    private String value;
    private Integer parentId;
    // private Integer level;
    private List<ToolTree> children = new ArrayList<>();

}
