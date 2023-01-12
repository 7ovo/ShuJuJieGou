package com.chf.heap;

public class HeapSort {
    /**
     * 判断堆中索引i处的元素是否小于索引j处的元素
     * @param heap 指定堆
     * @param i 元素索引
     * @param j 元素索引
     * @return 返回索引i处元素是否小于索引j处的元素
     */
    private static boolean less(Comparable[] heap,int i,int j){
        return heap[i].compareTo(heap[j]) < 0;
    }

    /**
     * 交换堆中索引i与索引j处的元素
     * @param heap 指定堆
     * @param i 元素索引
     * @param j 元素索引
     */
    private static void exchange(Comparable[] heap,int i,int j){
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * 根据原数组source，构造出堆heap
     * @param source 原数组
     * @param heap 堆
     */
    private static void createHeap(Comparable[] source,Comparable[] heap){
        //将数组的元素拷贝到堆中 这样堆中的元素就是无序的
        System.arraycopy(source,0,heap,1,source.length);
        //对堆中元素做下沉调整（从长度的一半开始 提高程序执行的性能）
        for(int i = (heap.length / 2);i > 0;--i){
            sink(heap,i,heap.length - 1);
        }
    }

    /**
     * 对source数组中的数组从小到大排序
     * @param source 数组
     */
    public static void sort(Comparable[] source){
        //构建堆
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source,heap);
        //定义变量记录未排序元素中最大的索引
        int N = heap.length - 1;
        while (N != 1){
            exchange(heap,1,N);
            N--;
            sink(heap,1,N);
        }
        //把堆的数据赋值到原数组
        System.arraycopy(heap,1,source,0,source.length);
    }

    /**
     * 在堆中对target处的元素做下沉
     * @param heap 指定堆
     * @param target 元素索引
     * @param range 范围0~range
     */
    public static void sink(Comparable[] heap,int target,int range){
        while (2 * target <= range){
            int max;
            if(2 * target + 1 <= range){
                if(less(heap,2 * target,2 * target + 1)) max = 2 * target + 1;
                else max = 2 * target;
            }else {
                max = 2 * target;
            }
            if (!less(heap,target,max)) break;
            exchange(heap,target,max);
            target = max;
        }
    }
}
