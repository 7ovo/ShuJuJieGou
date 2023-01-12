package com.chf.algorithm.test;

import com.chf.algorithm.Merge;

import java.util.Arrays;

public class MergeTest {
    public static void main(String[] args) {
        Integer[] array = {9,1,2,5,7,4,8,6,3,5};
        Merge.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
