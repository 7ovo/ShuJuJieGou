package com.chf.algorithm;
import java.util.Arrays;
/**
 * 2、选择排序算法      O(n^2)     不具有稳定性
 *
 * 选择次数           选择后的结果
 * -------------------------------------------
 * 初始结果          {3,11,64,21,65,37,9}
 * 第1趟排序         {3,11,64,21,65,37,9}
 * 第2趟排序         {3,9,11,64,21,65,37}
 * 第3趟排序         {3,9,11,21,64,65,37}
 * 第4趟排序         {3,9,11,21,37,64,65}
 * 第5趟排序         {3,9,11,21,37,64,65}
 * 选择排序的原理：假定第一初索引元素为最小值，与其他索引处的值依次进行比较，
 *              如若当前索引较大，则假定与其相比较的值最小，最后找到后放置最左边。
 * 选择排序的特点：
 */
public class Select{

    public static void sort(Comparable[] arr){
        for(int i = 0 ; i < arr.length - 2 ; i ++){
            int min = i;//假设i处的索引为最小的值
            for(int j = i + 1; j < arr.length ; j++){
                //如若某个索引的值小于初索引的值，则某个索引定义为min
                if(greater(arr[min],arr[j])){
                    min = j;
                }
            }
            exch(arr,i,min);
        }
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