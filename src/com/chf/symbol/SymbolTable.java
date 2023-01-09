package com.chf.symbol;

public class SymbolTable<K,V> {
    private Node head;//定义首结点
    private int N;//记录符号表中的元素个数

    private class Node{
        public K key;//键
        public V value;//值
        public Node next;//指向下一个结点
        public Node(K key,V value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 无参构造初始化首结点以及元素个数
     */
    public SymbolTable(){
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
        //符号表内以及存在了键 只需要找到键并且替换其值即可
        Node node = head;
        while(node.next != null){
            node = node.next;
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
        }
        //符号表内若不存在其键 则创建新的结点 保存到符号表内即可 将新结点插入到链表的头部
        Node newNode = new Node(key, value, null);
        Node n = head.next;
        head.next = newNode;
        newNode.next = n;
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
