package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class test {


    @Test
    public void test() {
        String str = "1,2,4,5,6,7,8,9";
        Integer id=7;
        List list = Arrays.asList(str.split(","));
        List arrList = new ArrayList(list);
        System.out.println(arrList);
        arrList.remove(id.toString());
        String str1=String.join(",",arrList);
        System.out.println(str1);

    }
}
