package com.chf.algorithm.test;

import com.chf.queue.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("张三");
        queue.enqueue("李四");
        queue.enqueue("王五");
        for(String s : queue){
            System.out.println("添加的元素为：" + s);
            //添加的元素为：张三
            //添加的元素为：李四
            //添加的元素为：王五
        }
        System.out.println("=====================");
        System.out.println("弹出的元素为：" + queue.dequeue());//弹出的元素为：张三
        System.out.println("剩余元素个数：" + queue.size());//2
    }
}
