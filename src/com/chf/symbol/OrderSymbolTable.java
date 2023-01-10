package com.chf.symbol;

public class OrderSymbolTable<K extends Comparable<K>,V> {
    private Node head;//定义首结点
    private int N;//记录符号表中的元素个数

    private class Node{
        public K key;//键
        public V value;//值
        public Node next;//指向下一个首节点(有效元素)
        public Node(K key,V value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 无参构造初始化首结点以及元素个数
     */
    public OrderSymbolTable(){
        this.head = new Node(null,null,null);
        this.N = 0;
    }

    /**
     * 判断符号表的长度
     * @return
     */
    public int size(){
        return N;
    }

    /**
     * 插入键值对
     * @param key 键
     * @param value 值
     */
    public void put(K key,V value){
        //定义两个节点 分别记录当前节点和当前节点的上一个节点
        Node currentNode = head.next;
        Node preNode = head;
        while (currentNode != null && key.compareTo(currentNode.key) > 0){
            preNode = currentNode;//当前节点的上一个节点变成当前节点
            currentNode = currentNode.next;//继续指向下一个节点
        }
        //如果当前节点的键和要插入的key一样则替换
        if(currentNode != null && key.compareTo(currentNode.key) == 0){
             currentNode.value = value;
             return;
        }
        //如果当前节点的键和要插入的key不一样 就把新的节点插到当前节点之前
        Node newNode = new Node(key,value,currentNode);
        preNode.next = newNode;

        N++;
    }

    /**
     * 删除键值对
     * @param key 键
     */
    public void delete(K key){
        Node node = head;
        while(node.next != null){
            if(node.next.key.equals(key)){
                node.next = node.next.next;
                N--;
                return;
            }
            node = node.next;
        }
    }

    /**
     * 根据键获得值
     * @param key 键
     * @return
     */
    public V get(K key){
        Node node = head;
        while (node.next != null){
            node = node.next;
            if(node.key.equals(key)){
                return node.value;
            }
        }
        return null;
    }
}
