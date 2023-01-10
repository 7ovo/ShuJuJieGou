package com.chf.linklist;

import java.util.Iterator;

/**
 * 顺序表
 * @param <T> 可自由指定泛型
 */
public class SequenceList<T> implements Iterable<T>{

    private T[] eles;//存储元素的数组
    private int N;//记录当前顺序表中的元素个数

    public SequenceList(int capacity){
        //初始化数组
        this.eles = (T[])new Object[capacity];
        //初始化元素个数
        this.N = 0;
    }

    //将一个线性表置为空表
    public void clear(){
        this.N = 0;
    }

    //判断当前线性表是否为空表
    public boolean isEmpty(){
        return this.N == 0;
    }

    //获取线性表的长度
    public int length(){
        return N;
    }

    //获取指定位置的元素
    public T get(int i){
        return eles[i];//时间复杂度为O(1)
    }

    //向线性表中添加元素t，可扩容为原数组的两倍大小
    public void insert(T t){
        if(N == eles.length){
            resize(2 * eles.length);
        }
        eles[N++] = t;
    }

    //向i元素处插入元素t，可扩容为原数组的两倍大小
    public void insert(int i,T t){
        if(N == eles.length){
            resize(2 * eles.length);
        }
        //先将i索引处的元素及其后面的元素依次向后移动一位
        for(int index = N;index > i;index--) {
            eles[index] = eles[index - 1];//时间复杂度为O(n)
        }
        //再把t元素放到i索引处即可
        eles[i] = t;
        N++;
    }

    //删除指定索引i处的元素，并返回该元素,，可缩容为原数组的二分之一
    public T remove(int i){
        //记录索引i处的值
        T current = eles[i];
        //索引i后面元素依次向前移动一位即可
        for(int index = i;index < N-1;index++){
            eles[index] = eles[index + 1];//时间复杂度为O(n)
        }
        N--;//元素个数减1
        if(N < eles.length/4){
            resize(eles.length/2);
        }
        return current;
    }

    //查找指定t元素第一次出现的索引，未找到就返回-1
    public int indexOf(T t){
        for(int i = 0;i < N;i++){
            if(eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    //根据参数newSize，重置eles的大小
    public void resize(int newSize){
        //定义一个临时数组，指向原数组
        T[] temp = eles;
        //创建新数组
        eles = (T[])new Object[newSize];
        //把原数组的数据拷贝到原数组即可
        for(int i = 0;i < N;i++){
            eles[i] = temp[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    public class SIterator implements Iterator{
        private int cusor;
        public SIterator(){
            this.cusor = 0;
        }
        @Override
        public boolean hasNext() {
            return cusor < N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }
}
