package com.chf.heap;

import java.util.Arrays;

public class HeapSortTest {
    public static void main(String[] args) {
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));//[A, E, E, L, M, O, P, R, S, T, X]
    }
}
