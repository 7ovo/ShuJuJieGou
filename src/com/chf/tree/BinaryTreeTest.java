package com.chf.tree;

import com.chf.linear.Queue;
import java.util.Iterator;

public class BinaryTreeTest {
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
        System.out.println("二叉树的元素个数为：" + tree.size());//8
        System.out.println("key为2的元素为：" + tree.get(2));//李四
        tree.delete(1);
        System.out.println("删除后的元素个数为：" + tree.size());//7
        System.out.println("key为1的元素为：" + tree.get(1));//null
        System.out.println("最小数为：" + tree.min());//2
        System.out.println("最大数为：" + tree.max());//10
        System.out.println("===============================================");
        /*
                                4赵六
                       2李四              6六六
                          3王五      5七七      10阿巴
                                            9舅子
         */
        //测试前序遍历
        //4---赵六
        //2---李四
        //3---王五
        //6---六六
        //5---七七
        //10---阿巴
        //9---舅子
        Queue<Integer> preErgodic = tree.preErgodic();
        for(Integer key : preErgodic){
            System.out.println(key + "---" + tree.get(key));
        }
        System.out.println("================================================");
        /*
                                4赵六
                       2李四              6六六
                          3王五      5七七      10阿巴
                                            9舅子
         */
        //测试中序遍历
        //2---李四
        //3---王五
        //4---赵六
        //6---六六
        //5---七七
        //10---阿巴
        //9---舅子
        Queue<Integer> midErgodic = tree.midErgodic();
        for(Integer key : midErgodic){
            System.out.println(key + "---" + tree.get(key));
        }
        System.out.println("================================================");
        /*
                                4赵六
                       2李四              6六六
                          3王五      5七七      10阿巴
                                            9舅子
         */
        //测试后序遍历
        //2---李四
        //3---王五
        //6---六六
        //5---七七
        //10---阿巴
        //9---舅子
        //4---赵六
        Queue<Integer> afterErgodic = tree.afterErgodic();
        for(Integer key : afterErgodic){
            System.out.println(key + "---" + tree.get(key));
        }
        System.out.println("================================================");
        /*
                                4赵六
                       2李四              6六六
                          3王五      5七七      10阿巴
                                            9舅子
         */
        //测试层序遍历
        //4---赵六
        //2---李四
        //6---六六
        //3---王五
        //5---七七
        //10---阿巴
        //9---舅子
        Queue<Integer> layerErgodic = tree.layerErgodic();
        for(Integer key : layerErgodic){
            System.out.println(key + "---" + tree.get(key));
        }
    }
}
