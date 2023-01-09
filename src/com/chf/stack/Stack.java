package com.chf.stack;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    private Node head;//记录首结点（在栈的顶部）
    private int N;//栈中元素个数

    private class Node{
        T item;//存储数据
        Node next;//指向下一个结点

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    public Stack(){
        this.head = new Node(null,null);
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    //把t元素压入栈
    public void push(T t){
        //找到首结点指向的第一个结点
        Node oldNode = head.next;
        //创建新结点
        Node newNode = new Node(t,null);
        //让首结点指向新结点
        head.next = newNode;
        //让新结点指向原来的第一个结点
        newNode.next = oldNode;
        N++;
    }

    //弹出栈顶元素
    public T pop(){
        //找到首结点指向的第一个结点
        Node oldNode = head.next;
        if(oldNode == null) return null;
        //让首结点指向原来第一个结点的下一个结点
        head.next = oldNode.next;
        N--;
        return oldNode.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private Node n;

        public SIterator(){
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}
