package com.chf.tree;

public class RedBlackTreeTest {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.put(5,"张三");
        tree.put(2,"李四");
        tree.put(1,"王五");
        System.out.println("id为1的值为：" + tree.get(1));//王五
        System.out.println("id为7的值为：" + tree.get(7));//null
    }
}
