package com.chf.linear;

/**
 * 1、快慢指针问题
 * 2、单链表中的带环问题
 * 3、证明有环链表入口问题：当快慢指针相遇时，证明链表中存在环问题，这时重新设定一个新指针指向链表的起点
 *                      且步长与慢指针一致，则慢指针与新指针相遇的地方即为环的入口。
 */
public class FastSlow {
    public static void main(String[] args) {
        Node<String> first = new Node<>("a",null);
        Node<String> second = new Node<>("b",null);
        Node<String> third = new Node<>("c",null);
        Node<String> fourth = new Node<>("d",null);
        Node<String> fifth = new Node<>("e",null);
        Node<String> six = new Node<>("f",null);
        Node<String> seven = new Node<>("g",null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;

        String mid = getMid(first);
        System.out.println("中间值为："+mid);

        seven.next = third;//产生环
        boolean circle = isCircle(first);
        System.out.println("first链表中是否有环："+circle);

        Node<String> entrance = getEntrance(first);
        System.out.println("first链表中的环的入口结点元素是："+entrance.item);

        //构建循环链表，让最后一个结点指向第一个结点
        seven.next = first;
    }

    /**
     * @param first 链表的首结点
     * @return 链表的中间结点的值
     */
    public static String getMid(Node<String> first){
        Node<String> fast = first;
        Node<String> slow = first;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }

    /**
     * 判断链表中是否有环
     * @param first 链表的首结点
     * @return true表示有环，false表示无环
     */
    public static boolean isCircle(Node<String> first){
        Node<String> fast = first;
        Node<String> slow = first;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast.equals(slow)) return true;
        }
        return false;
    }

    /**
     * 查找有环链表中环的入口结点
     * @param first 链表首结点
     * @return 环的入口结点
     */
    public static Node getEntrance(Node<String> first){
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast.equals(slow)){
                temp = first;
                continue;
            }
            if(temp != null){
                temp = temp.next;
                if(temp.equals(slow)){
                    break;
                }
            }
        }
        return temp;
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
