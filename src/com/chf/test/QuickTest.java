package com.chf.test;

import com.chf.algorithm.Quick;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        Integer[] arr = {9,1,2,5,7,4,8,6,3,5};
        Quick.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
