package com.chf.queue;

/**
 * 最小优先队列和先前所学的最大优先队列和堆有着不一样的区别：
 *      最小优先队列是将最小的元素放在索引1的位置处
 *      最小优先队列的父节点一定要小于等于它的子节点
 */
public class MinPriorityQueue<T extends Comparable<T>>{
    private T[] items;//存储堆中的元素
    private int N;//记录堆中元素个数

    public MinPriorityQueue(int capacity){
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    /**
     * 获取优先队列中元素个数
     * @return 返回元素个数
     */
    public int size(){
        return N;
    }

    /**
     * @return 返回队列是否为空
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * @param i 元素索引
     * @param j 元素索引
     * @return 返回堆中索引i处的元素是否小于索引j处的元素
     */
    private boolean less(int i,int j){
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换堆中索引i处与索引j处的值
     * @param i 元素索引
     * @param j 元素索引
     */
    private void exchange(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    /**
     * 插入元素
     * @param t 元素
     */
    public void insert(T t){
        items[++N] = t;
        this.swim(N);
    }

    /**
     * 删除堆中最小的元素
     * @return 返回被删除的元素
     */
    public T delMin(){
        T min = items[1];
        this.exchange(1,N);
        N--;
        this.sink(1);
        return min;
    }

    /**
     * 上浮算法：使索引i处的元素处于一个正确的位置
     * @param i 元素索引
     */
    private void swim(int i){
        while (i > 1){
            if (less(i,i / 2)) this.exchange(i,i / 2);
            i = i / 2;
        }
    }

    /**
     * 下沉算法：使索引i处的元素处于一个正确的位置
     * @param i 元素索引
     */
    private void sink(int i){
        while (N >= 2 * i){
            int min;
            if(N >= 2 * i + 1){
                if (this.less(i * 2,i * 2 +1)) min = i * 2;
                else min = 2 * i + 1;
            }else {
                min = 2 * i;
            }
            if(this.less(i,min)) break;
            this.exchange(i,min);
            i = min;
        }
    }
}
