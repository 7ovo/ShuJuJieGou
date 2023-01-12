package com.chf.queue;

public class MaxPriorityQueueTest {
    public static void main(String[] args) {
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<>(10);
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");
        while (!queue.isEmpty()){
            String s = queue.delMax();
            System.out.print(s + " ");
        }
    }
}
