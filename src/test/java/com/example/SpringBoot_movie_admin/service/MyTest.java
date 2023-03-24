package com.example.SpringBoot_movie_admin.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTest {


    @org.junit.Test
    public void test() {
        String str = "1,2,4,5,6,7,8,9";
        int id=7;
        List<String> list = Arrays.asList(str.split(","));
        List<String> arrList = new ArrayList<>(list);
        System.out.println(arrList);
        arrList.remove(id+"");
        String str1=String.join(",",arrList);
        System.out.println(str1);

    }
}
