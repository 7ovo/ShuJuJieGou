package com.chf.linklist;

import java.util.Iterator;

/**
 * 双向链表：由多个结点组成，头结点是没有数据的，每个结点都有一个数据域和两个指针域组成。
 *         数组域用来存储数据，其中一个指针域用来指向其后继结点，另一个指针域用来指向前继结点。
 *         链表的头结点的数据域不存储数据，指向前继结点的指针域值为null，指向后继结点的指针域指向第一个真正存储数据的结点。
 * @param <T> 可自由指定泛型
 */
public class TwoWayLinkList<T> implements Iterable<T>{
    private Node head;//首结点
    private Node last;//最后一个结点
    private int N;//链表的长度

    private class Node{
        public T item;//存储数据
        public Node pre;//指向上一个结点
        public Node next;//指向下一个结点
        public Node(T item,Node pre,Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public TwoWayLinkList(){
        //初始化头结点和尾结点
        this.head = new Node(null,null,null);
        this.last = null;
        //初始化元素个数
        this.N = 0;
    }

    //清空链表
    public void clear(){
        this.head.next = null;
        this.head.pre = null;
        this.head.item = null;
        this.last = null;
        this.N = 0;
    }


    //获取链表长度
    public int length(){
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //获取第一个元素
    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        return head.next.item;
    }

    //获取最后一个元素
    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return last.item;
    }

    //插入元素t
    public void insert(T t){
        if(isEmpty()){  //如果链表为空
            //创建新的结点
            Node newNode = new Node(t,head,null);
            //让新结点称为尾结点
            last = newNode;
            //让头结点指向尾结点
            head.next = last;
        }else {
            //创建新的结点
            Node newNode = new Node(t,last,null);
            //让当前的尾结点指向新结点
            last.next = newNode;
            //让新结点称为尾结点
            last = newNode;
        }
        N++;
    }

    //在指定位置i处插入元素t
    public void insert(int i,T t){
        //找到i位置的前一个结点
        Node preNode = head;
        for(int index = 0;index < i;index++){
            preNode = preNode.next;
        }
        //找到i位置的结点
        Node currentNode = preNode.next;
        //创建新结点
        Node newNode = new Node(t,preNode,currentNode);
        //让i位置的前一个结点的下一个结点变为新结点（也就是当前结点）
        preNode.next = newNode;
        //让i位置的前一个结点变为新结点
        currentNode.pre = newNode;
        N++;//元素个数+1
    }

    //获取指定位置i处的元素
    public T get(int i){
        Node n = head.next;
        for(int index = 0;index < i;index++){
            n = n.next;
        }
        return n.item;
    }

    //获取元素t在链表中第一次出现的位置
    public int indexOf(T t){
        Node n = head;
        for(int i = 0;n.next != null;i++){
            n = n.next;
            if(n.next.equals(t)){
                return i;
            }
        }
        return -1;
    }

    //删除位置i处的元素，并返回该元素的值
    public T remove(int i){
        //找到i位置的前一个结点
        Node preNode = head;
        for(int index = 0;index < i;index++){
            preNode = preNode.next;
        }
        //找到i位置的结点
        Node currentNode = preNode.next;
        //找到i位置的下一个结点
        Node nextNode = currentNode.next;
        //让i位置的前一个结点的下一个结点变为i位置的下一个结点
        preNode.next = nextNode;
        //让i位置的下一个结点的上一个结点变为i位置的前一个结点
        currentNode.pre = preNode;
        N--;//元素个数-1
        return currentNode.item;
    }
    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }
    public class TIterator implements Iterator{
        private Node n;
        public TIterator(){
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
