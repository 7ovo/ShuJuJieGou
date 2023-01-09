package com.chf.algorithm;

import java.util.Arrays;

/**
 * 6、快速排序（要求精通）   O(n log n)    具有稳定性
 *
 * 排序次数              排序后的结果
 * ------------------------------------
 *
 *
 * 快速排序的原理：1、首先设定一个分界值，用两个指针分别指向数组的头部和尾部
 *              2、先从尾部向头部搜索比分界值小的元素，搜索到即停止，并记录指针的位置
 *              3、再从尾部向头部搜索比分界值大的元素，搜索到即停止，并记录指针的位置
 *              4、交换当前左边指针位置和右边指针位置
 *              5、重复2,3,4步骤，直到左边指针的值大于右边指针的值停止
 */
public class Quick {

    //对数组内的元素进行排序
    public static void sort(Comparable[] a){
       int low = 0;
       int height = a.length - 1;
       sort(a,low,height);
    }

    //对数组a中从索引low到索引height之间的元素进行排序
    public static void sort(Comparable[] a,int low,int height){
        //做安全性校验
        if(height <= low){
            return;
        }
        //对数组中索引low到height索引的元素进行分组（左子组和右子组）
        int partition = partition(a,low,height);//返回的是分组的分界值所在的索引，分界值位置变换后的索引
        //让左子组排序
        sort(a,low,partition - 1);
        //让右子组排序
        sort(a,partition + 1,height);;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    private static int partition(Comparable[] a,int low,int height){
        //确定分界值
        Comparable key = a[low];
        //定义两个指针，分别指向待切分元素的最小索引处和最大索引处的下一个位置
        int left = low;
        int right = height + 1;
        //切分
        while(true){
            //先从右往左扫描，移动right指针，找到一个比分界值小的元素，停止
            while(less(key,a[--right])){
                if(right == low){
                    break;
                }
            }
            //再从左往右扫描，移动left指针，找到一个比分界值大的元素，停止
            while(less(a[++left],key)){
                if(left == height){
                    break;
                }
            }
            //判断left >= right，是的话则证明元素扫描完毕，结束循环，如果不是，则交换元素即可
            if(left >= right){
                break;
            }else {
                exch(a,left,right);
            }
        }
        //交换分界值
        exch(a,low,right);
        return right;
    }
}
