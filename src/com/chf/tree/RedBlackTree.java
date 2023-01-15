package com.chf.tree;

/*
红黑树：是一种自平衡的二叉查找树。
    性质1：根节点的元素总是黑色的；
    性质2：每个结点不是红色就是黑色；
    性质3：红链接均为左链接；
    性质4：没有任何一个结点同时和两条红链接相连即如果一个节点是红色的，则它的两个孩子结点是黑色的
    性质5：是完美黑色平衡的，即任意空链接到根结点的路径上的黑链接数量相同；
 */
public class RedBlackTree<K extends Comparable<K>,V> {
    private Node root;//记录根结点
    private int N;//记录树中元素个数
    private static final boolean RED = true;//红色节点标识
    private static final boolean BLACK = false;//黑色节点标识

    private class Node{
        public K key;//存储键
        public V value;//存储值
        public Node left;//存储左子节点
        public Node right;//存储右子节点
        public boolean color;//存储父节点指向子节点的链接颜色

        public Node(K key, V value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 判断当前节点是否为红色
     * @param node 当前节点
     * @return 返回当前节点是否为红色
     */
    private boolean isRed(Node node){
        if(node == null) return false;
        return node.color == RED;
    }

    /**
     * 当左子节点为黑色并且当前结点的右子节点为红色就进行左旋
     * @param parent 父节点
     * @return 返回左旋后的右子节点
     */
    private Node rotateLeft(Node parent){
        //获取父节点(parent)的右子节点(rightChildNode)
        Node rightChildNode = parent.right;
        //让右子节点(rightChildNode)的左子节点成为父节点(parent)的右子节点
        parent.right = rightChildNode.left;
        //让父节点(parent)成为右子节点(rightChildNode)的左子节点
        rightChildNode.left = parent;
        //让右子节点(rightChildNode)的color属性等于父节点(parent)的color属性，即默认的黑色
        rightChildNode.color = parent.color;
        //让父节点(parent)的color属性变成红色
        parent.color = RED;
        return rightChildNode;
    }

    /**
     * 当左子节点为红节点并且它的左子节点也为红色点就需要右旋
     * @param parent 父节点
     * @return 返回右旋后的左子节点
     */
    private Node rotateRight(Node parent){
        //获取父节点(parent)的左子节点(leftChildNode)
        Node leftChildNode = parent.left;
        //让左子节点(leftChildNode)的右子节点成为父节点(parent)的左子节点
        parent.left = leftChildNode.right ;
        //让父节点(parent)成为左子节点(leftChildNode)的右子节点
        leftChildNode.right = parent;
        //让左子节点(leftChildNode)的color属性等于父节点(parent)的color属性
        leftChildNode.color = parent.color;
        //让父节点(parent)的color属性变成红色
        parent.color = RED;
        return leftChildNode;
    }

    /**
     * 当左子节点与右子节点均为红色就需要颜色反转 相当于完成拆分4-节点
     * @param node 当前结点
     */
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 往树中插入元素
     * @param key 键
     * @param value 值
     */
    public void put(K key,V value){
        root = this.put(root,key,value);
        root.color = BLACK;
    }

    /**
     * 指定树中插入元素
     * @param node 指定树
     * @param key 键
     * @param value 值
     * @return 返回添加元素后的新树
     */
    public Node put(Node node,K key,V value){
        if(node == null){
            N++;
            return new Node(key,value,null,null,RED);
        }
        int i = key.compareTo(node.key);
        if(i > 0){
            node.right = put(node.right,key,value);
        }else if(i < 0){
            node.left = put(node.left,key,value);
        }else {
            node.value = value;
        }
        //如果当前节点的左子节点为黑色并且当前结点的右子节点为红色就进行左旋
        if(!this.isRed(node.left) && this.isRed(node.right)) node = this.rotateLeft(node);
        //如果当前节点的左子节点和当前节点的左子节点的左子节点均为红色就进行右旋
        if(this.isRed(node.left) && this.isRed(node.left.left)) node = this.rotateRight(node);
        //如果当前结点的左子节点与右子节点均为红色就需要颜色反转
        if(this.isRed(node.left) && this.isRed(node.right)) this.flipColors(node);
        return node;
    }

    public V get(K key){
        return this.get(root,key);
    }

    public V get(Node node,K key){
        if(node == null) return null;
        int i = key.compareTo(node.key);
        if(i > 0){
            return get(node.right,key);
        }else if(i < 0){
            return get(node.left,key);
        }else {
            return node.value;
        }
    }
}
