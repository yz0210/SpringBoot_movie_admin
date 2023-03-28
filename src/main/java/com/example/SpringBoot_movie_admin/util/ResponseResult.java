package com.example.SpringBoot_movie_admin.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResponseResult<T> {
    private Integer status;
    private String message;
    private T data;

    public ResponseResult(String message, T data) {
        super();
        this.message = message;
        this.data = data;
    }

    public ResponseResult(Integer status,String message, T data) {
        super();
        this.status=status;
        this.message = message;
        this.data = data;
    }



}
