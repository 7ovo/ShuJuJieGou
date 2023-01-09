package com.chf.algorithm;
import java.util.Arrays;
/**
 * 1、冒泡排序算法    O(n^2)    具有稳定性
 *
 * 冒泡次数            冒泡后的结果
 * -----------------------------------
 * 初始结果          {9,8,10,7,6,0,11}
 * 第1次冒泡         {9,8,10,8,6,0,11} 比较了6次 取出最大值11 剩下6个数
 * 第2次冒泡         {9,8,8,6,0,10,11} 取出最大值10 剩下5个数
 * 第3次冒泡         {8,8,6,0,9,10,11} 取出最大值9  剩下4个数
 * 第4次冒泡         {8,6,0,8,9,10,11} 取出最大值8  剩下3个数
 * 第5次冒泡         {6,0,8,8,9,10,11} 取出最大值8  剩下2个数
 * 第6次冒泡         {0,6,8,8,9,10,11} 取出最大值6  剩下1个数
 *
 * 冒泡排序的原理：从左边开始相邻的两个往右边比较，相当于在比较的过程中将大的数一直右移
 * 冒泡排序的特点：冒泡次数为（总个数-1），总比较次数为（2加到length），从数组下标为0，一直到数组下标为（length-1）
 */
public class Bubble{

    public static void sort(Comparable[] arr){
        for(int i = arr.length - 1; i > 0 ; i--){
            for(int j = 0;j < i; j++){
                //如果相邻两个数中左边的值大于右边的值，则交换
                if(greater(arr[j],arr[j + 1])){
                    exch(arr, j, j + 1);
                }
            }
        }
        /*或者
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ;j  < arr.length - 1 - i; j++){
                if(greater(arr[j],arr[j + 1])){
                    exch(arr, j, j + 1);
                }
            }
        }
         */
    }

    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w) > 0;
    }

    public static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}