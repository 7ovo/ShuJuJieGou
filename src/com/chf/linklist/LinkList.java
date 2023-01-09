package com.chf.linklist;

import java.util.Iterator;

/**
 * 单向链表：由多个节点组成，每个节点都由一个数据域和一个指针域组成。
 *         头结点是没有数据的，数据域用来存储数据，指针域用来指向后继节点。
 *         链表的头结点的数据域不存储数据，指针域指向第一个真正存储数据的节点。
 * 末尾有链表反转的方法，面试题可能会需要。
 *
 * @param <T> 可自由指定泛型
 */
public class LinkList<T> implements Iterable<T>{

    private Node head;//记录头结点
    private int N;//记录链表的长度

    //结点类
    private class Node{
        T item;//存储数据
        Node next;//指向下一个结点

        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }

    public LinkList(){
        this.head = new Node(null,null);//初始化头结点
        this.N = 0;//初始化元素个数
    }

    //清空链表
    public void clear(){
        head.next = null;
        this.N = 0;
    }

    //获取链表的长度
    public int length(){
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //读取并返回线性表中的第i个元素的值
    public T get(int i){
        //从头结点开始往后找
        Node n = head.next;
        for(int index = 0;index < i;index++){
             n = n.next;
        }
        return n.item;
    }

    //向链表中添加元素t
    public void insert(T t){
        //找到当前最后一个结点
        Node n = head;
        while(n.next != null){
            n = n.next;
        }
        //创建新结点，保存元素t
        Node newNode = new Node(t,null);
        //让当前最后一个结点指向新结点
        n.next = newNode;
        N++;//长度+1
    }

    //向指定位置i处，添加元素
    public void insert(int i,T t){
        //找到i位置前一个结点
        Node preNode = head;
        for(int index = 0;index < i;index++){
            preNode = preNode.next;
        }
        //找到i位置的结点
        Node currentNode = preNode.next;
        //创建新结点，并且新结点需要指向原来i位置的节点
        Node newNode = new Node(t,currentNode);
        //原来i位置的前一个结点指向新结点即可
        preNode.next = newNode;
        N++;
    }

    //删除并返回位置i处的元素
    public T remove(int i){
        //找到i位置前一个结点
        Node preNode = head;
        for(int index = 0;index < i;index++){
            preNode = preNode.next;
        }
        //找到i位置的节点
        Node currentNode = preNode.next;
        //找到i位置后一个结点
        Node nextNode = currentNode.next;
        //前一个结点指向下一个结点
        preNode.next = nextNode;
        N--;
        return currentNode.item;
    }

    //查找元素t在链表中第一次出现的位置
    public int indexOf(T t){
        //从头结点开始，依次找到每一个结点，取出item，和t比较，如果相同就找到了
        Node n = head;
        for(int i = 0;n.next != null;i++){
            n = n.next;
            if(n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    public class LIterator implements Iterator{
        private Node n;
        public LIterator(){
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

    //反转整个链表
    public void reverse(){
        if(isEmpty()){
            return;
        }
        reverse(head.next);
    }

    //反转指定的结点curr，并把反转后的结点返回
    public Node reverse(Node node){
        if(node.next == null){
            head.next = node;
            return node;
        }
        //递归的反转当前结点curr的下一个结点：返回值就是链表反转后，当前结点的下一个结点
        Node currentNode = reverse(node.next);
        currentNode.next = node;
        node.next = null;
        return node;
    }
}
