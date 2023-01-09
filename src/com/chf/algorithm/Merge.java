package com.chf.algorithm;

import java.util.Arrays;
/**
 * 5、归并排序     O(n log n)     不具有稳定性
 *
 * 分组次数                            分组后的结果
 * ----------------------------------------------------------------------
 * 初始结果                      {9,1,2,5,7,4,8,6,3,5}
 * 第1趟分组                    {9,1,2,5,7}、{4,8,6,3,5}
 * 第2趟分组                 {9,1,2}、{5,7}、 {4,8,6}、{3,5}
 * 第3趟分组           {9,1}、{2}、{5}、{7}、   {4,8}、{6}、{3}、{5}
 * 第4趟分组       {9}、{1}、{2}、{5}、{7}、     {4}、{8}、{6}、{3}、{5}
 *
 * 第1次合并            {1,9}、{2,5}、{7}、      {4,8}、{3,6}、{5}
 * 第2次合并                 {1,2,5,9}、{7}、 {3,4,6,8}、{5}
 * 第3次合并                     {1,2,5,7,9}、{3,4,5,6,8}
 * 第4次合并                      {1,2,3,4,5,5,6,7,8,9}
 * 归并排序的原理：将一组原数据尽可能拆分成两个元素相同的子数据组，进而继续拆分到每个组都为1为之
 *         将相邻两个子组合并成一个有序大组，不断重复此操作。
 */
public class Merge {

    private static Comparable[] assist;//归并所需要的辅助数组

    /*
    对数组a的元素进行排序
     */
    public static void sort(Comparable[] a){
        //1、初始化辅助数组assist
        assist = new Comparable[a.length];
        //2、定义一个low变量和height变量，分别记录数组中最小的索引和最大的索引
        int low = 0;
        int height = a.length-1;
        //3、调用sort重载方法完成数组a中，从索引low到索引height的元素排序
        sort(a,low,height);
    }

    /*
    对数组a中从low到height的元素进行排序
     */
    public static void sort(Comparable[] a, int low, int height){
        //1、做安全性校验
        if(height <= low){
            return;
        }
        //2、对low到height之间的数据进行分组
        int mid = low + (height - low)/2;
        //3、分别对每一组数据进行排序
        sort(a,low,mid);
        sort(a,mid + 1,height);
        //4、再把分完组后的数据进行归并
        merge(a,low,mid,height);
    }

    /*
    对数组中，从low到mid为一组，从mid+1到height为一组，对这两组数据进行合并
     */
    private static void merge(Comparable[] a,int low ,int mid,int height){
        //1、定义三个指针
        int i = low;
        int p1 = low;
        int p2 = mid + 1;
        //2、遍历，移动两个指针，比较对应索引处的值，找出最小的放在辅助数组中
        while(p1 <= mid && p2 <= height){
            //比较对应所索引处的值
            if(less(a[p1],a[p2])){
                assist[i++] = a[p1++];
            }else {
                assist[i++] = a[p2++];
            }
        }
        //3、遍历，如果第一个指针没有走完，那么顺序移动第一个指针，把对应的元素放到辅助数组的对应索引处
        while(p1 <= mid){
            assist[i++] = a[p1++];
        }
        //4、遍历，如果第二个指针没有走完，那么顺序移动第二个指针，把对应的元素放到辅助数组的对应索引处
        while(p2 <= height){
            assist[i++] = a[p2++];
        }
        //5、把辅助数组中的元素拷贝到原数组中
        for(int index = low; index <= height; index++){
            a[index] = assist[index];
        }
    }

    private static boolean less(Comparable v,Comparable w){
        //传入的前者（v.compareTo(w)）的v若大于w，则返回1，综合返回为false
        return v.compareTo(w) < 0;
    }

    /*private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }*/
}
