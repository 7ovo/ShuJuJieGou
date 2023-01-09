package com.chf.test;

import com.chf.algorithm.Insert;

import java.util.Arrays;

public class InsertTest {
    public static void main(String[] args){
        Integer[] arr = {3,11,64,21,65,37,9};
        Insert.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
