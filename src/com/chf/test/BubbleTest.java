package com.chf.test;

import com.chf.algorithm.Bubble;

import java.util.Arrays;

public class BubbleTest {
    public static void main(String[] args) {
        Integer[] arr = {9,8,10,7,6,0,11};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
