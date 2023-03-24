package com.example.SpringBoot_movie_admin.util;

public class ResponseResult<T> {
    private Integer status;
    private String message;
    private T data;

    public ResponseResult(Integer status, T data) {
        super();
        this.status = status;
        this.data = data;
    }

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


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer state) {
        this.status = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
