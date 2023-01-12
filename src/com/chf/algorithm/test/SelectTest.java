package com.chf.algorithm.test;

import com.chf.algorithm.Select;

import java.util.Arrays;

public class SelectTest {
    public static void main(String[] args) {
        Integer[] arr = {3,11,64,21,65,37,9};
        Select.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
