package com.chf.heap;

/**
 *     堆中父节点大于或等于两个子节点
 *     假设堆中父节点的索引为i，对应的索引为2i与2i+1为它的子节点
 *     堆总是一棵完全二叉树。
 * @param <T>
 */
public class Heap<T extends Comparable<T>> {
    private T[] items;//存储堆中的元素
    private int N;//堆中元素的个数

    public Heap(int capacity){
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    /**
     * 判断堆中索引i处元素是否小于索引j处的元素
     * @param i 元素索引
     * @param j 元素索引
     * @return 返回索引i处元素是否小于索引j处的元素
     */
    private boolean less(int i,int j){
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换堆中索引i处与索引j处的元素
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
        //堆存储中让索引0处不放置元素 为了后续的操作
        items[++N] = t;
        this.swim(N);
    }

    /**
     * 使用上浮算法 使索引i处元素能在堆中处于一个正确的位置
     * @param i 元素下标
     */
    private void swim(int i){
        //循环比较当前节点的值比父节点的值 比父节点大则交换
        while (i > 1){
            if(this.less(i / 2,i)) this.exchange(i / 2,i);
            i = i / 2;
        }
    }

    /**
     * 删除堆中最大的元素
     * @return 返回最大的元素
     */
    public T delMax(){
        T max = items[1];
        //交换最大的元素与索引最大的元素 让索引最大的元素成为临时根结点
        this.exchange(1,N);
        items[N] = null;
        N--;
        //通过下沉算法 让堆重新有序
        this.sink(1);
        return max;
    }

    /**
     * 下沉算法 使索引i处元素能在堆中处于一个正确的位置
     * @param i 元素索引
     */
    private void sink(int i){
        //通过不断循环比较当前节点索引(i)与其左右子节点索引(2i,2i+1)比较大小
        //循环的条件是判断当前节点是否有左子节点
        while (N >= 2 * i){
            int max;//判断左右子节点中的最大值处的索引
            //判断条件是判断当前节点是否有右子节点
            if(N >= 2 * i + 1){
                if(this.less(2 * i,2 * i + 1)) max = 2 * i + 1;
                else max = 2 * i;
            }else{
                max = 2 * i;
            }
            //比较当前节点和较大节点的值
            if(!this.less(i,max)) break;
            //如果当前节点比较小就对两者索引处的值进行交换
            this.exchange(i,max);
            i = max;
        }
    }
}
