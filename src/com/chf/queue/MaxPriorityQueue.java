package com.chf.queue;

/**
 * 普通的队列是一种先进先出的数据结构。元素在队列尾追加，而从队列头删除。在某些情况下，我们可以需要找出队列中的最大值或者最小值，
 * 例如使用一个队列保存计算机的任务，一般情况下计算机的任务都是有优先级的，我们需要在这些计算机的任务中找出优先级最高的任务先执行，
 * 执行完毕就后就需要把这个任务从队列中移除。普通的队列要完成这样的功能，需要每次遍历队列中所有元素，比较并找出最大值，效率不是很高，
 * 这个时候，我们就可以使用一种特殊的队列来完成这种需求：优先队列。
 * 优先队列按照其作用不同，可以分为以上两种：
 *      最大优先队列：可以获取并删除队列中最大的值
 *      最小优先队列：可以获取并删除队列中最小的值
 */
public class MaxPriorityQueue<T extends Comparable<T>>{
    private T[] items;//存储堆中的元素
    private int N;//记录堆中元素个数

    public MaxPriorityQueue(int capacity){
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
     * 删除堆中最大的元素
     * @return 返回被删除的元素
     */
    public T delMax(){
        T max = items[1];
        this.exchange(1,N);
        N--;
        this.sink(1);
        return max;
    }

    /**
     * 上浮算法：使索引i处的元素处于一个正确的位置
     * @param i 元素索引
     */
    private void swim(int i){
        while (i > 1){
            if (less(i / 2,i)) this.exchange(i / 2,i);
            i = i / 2;
        }
    }

    /**
     * 下沉算法：使索引i处的元素处于一个正确的位置
     * @param i 元素索引
     */
    private void sink(int i){
        while (N >= 2 * i){
            int max;
            if(N >= 2 * i + 1){
                if (this.less(i * 2,i * 2 +1)) max = i * 2 + 1;
                else max = 2 * i;
            }else {
                max = 2 * i;
            }
            if(!this.less(i,max)) break;
            this.exchange(i,max);
            i = max;
        }
    }
}
