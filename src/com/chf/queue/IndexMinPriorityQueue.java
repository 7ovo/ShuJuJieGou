package com.chf.queue;

public class IndexMinPriorityQueue<T extends Comparable<T>> {
    private T[] item;//用来存储元素的数组
    private int N;//记录索引优先队列中元素个数
    private int[] pq;//保存每个元素在数组中的索引，索引0处没有元素，pq要求堆有序
    private int[] qp;//保存pq的逆序 pq的值作为索引 pq的索引作为值

    public IndexMinPriorityQueue(int capacity){
        this.item = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        this.N = 0;
        //默认情况下 队列中没有存储任何数据
        for(int i = 0;i < qp.length;++i) qp[i] = -1;
    }

    public int size(){
        return N;
    }

    public boolean inEmpty(){
        return N == 0;
    }

    private boolean less(int i,int j){
        return item[pq[i]].compareTo(item[pq[j]]) < 0;
    }
}
