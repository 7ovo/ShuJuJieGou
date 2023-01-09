package com.chf.algorithm;
import java.util.Arrays;
/**
 * 3、插入排序算法      O(n^2)    具有稳定性
 *
 * 插入次数           插入后的结果
 * -----------------------------------------
 * 初始结果          {3,11,64,21,65,37,9}
 * 第1趟插入         {3,11,64,21,65,37,9} 从索引为1的11跟3比
 * 第2趟插入         {3,11,64,21,65,37,9} 从索引为2的64跟11比
 * 第3趟插入         {3,11,21,64,65,37,9} 从索引为3的21跟64比，交换位置再跟11比
 * 第4趟插入         {3,11,21,64,65,37,9} 从索引为4的65跟64比
 * 第5趟插入         {3,11,21,37,64,65,9} ....
 * 第6趟插入         {3,9,11,21,37,64,65} ....
 * 插入排序的原理：从数组索引为1的元素依次向左比较，如若左边的元素大于右边的元素就换位，将大的元素往右移
 * 插入排序的特点：
 */
public class Insert{

	public static void sort(Comparable[] arr){
		for(int i = 1 ; i < arr.length;i++){
			for(int j = i ; j > 0;j--){
				if(greater(arr[j - 1],arr[j])){
					exch(arr,j - 1,j);
				}else {
					break;
				}
			}
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