package com.chf.algorithm;
import java.util.Arrays;
/**
 * 4、希尔排序算法（插入排序的改良版）    O(n log n)     不具有稳定性
 *
 * 插入次数           插入后的结果
 * -----------------------------------------
 * 初始结果          {9,1,2,5,7,4,8,6,3,5}
 * 第1趟排序         {4,1,2,3,5,9,8,6,5,7} 索引为0的9与索引为(0+5)的4一组  ....如若左比右大，就交换位置
 * 第2趟排序         {2,1,4,3,5,6,5,7,8,9}
 * 第3趟排序         {1,2,3,4,5,5,6,7,8,9}
 * 希尔排序的原理：选定一个增长量，令其作为数据分组的依据，对分完组的数据完成插入排序，
 *              再减小增长量（最小为1），重复分组对数据进行插入排序。
 * 希尔排序的特点：
 */
public class Shell{

	public static void sort(Comparable[] arr){
		//1、根据数组a的长度，确定增长量h的初始值
		int h = arr.length/2;
		while(h >= 1){
		//2、找到待插入的元素
			for(int i = h; i < arr.length; i++){
				//3、把待插入的元素插入到有序数列中
				for(int j = i; j >= h; j = j - h){
					//待插入的元素是a[j]，与a[j-h]比较
					if(greater(arr[j-h],arr[j])){
						exch(arr,j-h,j);
					}else{
						break;
					}
				}
			}
			h = h/2;
		}
	}
	public static boolean greater(Comparable v,Comparable w){
		return v.compareTo(w)>0;
	}
	public static void exch(Comparable[] a,int i,int j){
		Comparable temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}