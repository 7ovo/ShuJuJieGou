package com.chf.linklist;

/**
 * 解决约瑟夫问题
 */
public class Joseph {
    public static void main(String[] args) {
        //1、构建循环链表，包含41个结点，分别存储1~41的值
        Node<Integer> firstNode = null;//用来记录首结点
        Node<Integer> preNode = null;//用来记录前一个结点
        for(int i = 1;i < 42;i++){
            if(i == 1){
                firstNode = new Node<>(i,null);
                preNode = firstNode;
                continue;
            }
            Node<Integer> newNode = new Node<>(i,null);
            preNode.next = newNode;
            preNode = newNode;
            if(i == 41){
                preNode.next = firstNode;//循环链表
            }
        }
        //2、需要count计数器，模拟报数
        int count = 0;
        //3、遍历循环链表
        Node<Integer> n = firstNode;//记录每次遍历拿到的结点，默认从首结点开始
        Node<Integer> before = null;//记录当前结点的上一个结点
        while(n != n.next){
            count++;//模拟报数
            if(count == 3){
                //把当前结点删除调用，打印当前结点，重置count为0，让当前结点n后移
                before.next = n.next;
                System.out.print(n.item + " ");
                count = 0;//重置
                n = n.next;
            }else {
                //让before变为当前结点，让当前结点后移
                before = n;
                n = n.next;
            }
        }
        System.out.println();
        System.out.print("最后存活的元素为："+n.item+"，以及上一个元素");//打印最后一个元素
    }

    private static class Node<T>{
        T item;//存储数据
        Node next;//指向下一个结点

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }
}
