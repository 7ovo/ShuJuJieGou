package com.chf.queue;

public class MinPriorityQueueTest {
    public static void main(String[] args) {
        MinPriorityQueue<Integer> queue = new MinPriorityQueue<>(10);
        queue.insert(5);
        queue.insert(2);
        queue.insert(7);
        queue.insert(9);
        queue.insert(1);
        queue.insert(4);
        queue.insert(8);
        while (!queue.isEmpty()){
            Integer min = queue.delMin();
            System.out.print(min + " ");//1 2 4 5 7 8 9
        }
    }
}
