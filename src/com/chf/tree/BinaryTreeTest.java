package com.chf.tree;

import com.chf.linear.Queue;
import java.util.Iterator;

public class BinaryTreeTest {
    public BinaryTreeTest() {
    }

    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.put(4, "赵六");
        tree.put(1, "张三");
        tree.put(2, "李四");
        tree.put(3, "王五");
        tree.put(6, "六六");
        tree.put(10, "阿巴");
        tree.put(5, "七七");
        tree.put(9, "舅子");
        System.out.println("二叉树的元素个数为：" + tree.size());
        String node = (String)tree.get(2);
        System.out.println("key为2的元素为：" + node);
        tree.delete(1);
        System.out.println("删除后的元素个数为：" + tree.size());
        System.out.println("key为1的元素为：" + (String)tree.get(1));
        System.out.println("最小数为：" + tree.min());
        System.out.println("最大数为：" + tree.max());
        System.out.println("===============================================");
        Queue<Integer> preErgodic = tree.preErgodic();
        Iterator var4 = preErgodic.iterator();

        while(var4.hasNext()) {
            Integer i = (Integer)var4.next();
            System.out.println(i + "---" + (String)tree.get(i));
        }

        System.out.println("================================================");
        Queue<Integer> midErgodic = tree.midErgodic();
        Iterator var10 = midErgodic.iterator();

        while(var10.hasNext()) {
            Integer i = (Integer)var10.next();
            System.out.println(i + "---" + (String)tree.get(i));
        }

        System.out.println("================================================");
        Queue<Integer> afterErgodic = tree.afterErgodic();
        Iterator var12 = afterErgodic.iterator();

        while(var12.hasNext()) {
            Integer i = (Integer)var12.next();
            System.out.println(i + "---" + (String)tree.get(i));
        }

        System.out.println("================================================");
        Queue<Integer> layerErgodic = tree.layerErgodic();
        Iterator var14 = layerErgodic.iterator();

        while(var14.hasNext()) {
            Integer i = (Integer)var14.next();
            System.out.println(i + "---" + (String)tree.get(i));
        }

    }
}
