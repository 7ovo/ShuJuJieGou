package com.chf.tree;

import com.chf.linear.Queue;

/**
 * 模拟折纸问题：下折痕为左子节点 上折痕为右子节点
 */
public class PagerFoldingTest {
    public static void main(String[] args) {
        Node<String> tree = createTree(2);
        printTree(tree);
    }

    /**
     * 通过模拟对折N次纸 产生树
     * @param N
     * @return
     */
    public static Node<String> createTree(int N){
        Node<String> root = null;//定义根结点
        for(int i = 0;i < N;++i){
            //第一次对折
            if(i == 0){
                root = new Node<>("down",null,null);
                continue;//结束i = 0的循环 不继续往下走
            }
            //定义辅助队列 通过层序遍历的思想
            Queue<Node> queue = new Queue<>();
            queue.enqueue(root);
            //找到叶子节点 为其添加子节点
            while(!queue.isEmpty()){
                Node<String> node = queue.dequeue();//弹出一个节点
                //判断是否有左子节点或右子节点 如果有就将其放到队列中
                if(node.left != null) queue.enqueue(node.left);
                if(node.right != null) queue.enqueue(node.right);
                //如果没有左子节点与右子节点 就证明是叶子节点 为其添加左子节点与右子节点
                if(node.left == null && node.right == null){
                    node.left = new Node<String>("down",null,null);//下折痕为左子节点
                    node.right = new Node<String>("up",null,null);//上折痕为右子节点
                }
            }
        }
        return root;
    }

    /**
     * 中序遍历打印树中每个节点到控制台
     * @param root
     */
    public static void printTree(Node<String> root){
        if(root == null) return;
        if(root.left != null) printTree(root.left);
        System.out.print(root.data + " ");
        if(root.right != null) printTree(root.right);
    }

    public static class Node<T>{
        public T data;//存储元素的数据
        public Node left;//左子节点
        public Node right;//右子节点

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
