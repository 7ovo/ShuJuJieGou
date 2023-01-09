package com.chf.test;

import com.chf.linklist.LinkList;

public class LinkListTest {
    public static void main(String[] args) {
        LinkList<String> s1 = new LinkList<>();
        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦迪");
        s1.insert(1,"詹姆斯");
        for(String a : s1){
            System.out.println(a);
        }
        String result = s1.get(1);
        System.out.println("索引1处的值为："+result);
        String removeResult = s1.remove(3);
        System.out.println("删除的元素为："+removeResult);
        s1.clear();
        System.out.println("当前线性表的元素个数为："+s1.length());

        System.out.println("==========================================================");

        LinkList<String> s2 = new LinkList<>();
        s2.insert("姚明");
        s2.insert("科比");
        s2.insert("麦迪");
        s2.insert(1,"詹姆斯");
        s2.reverse();
        for(String b : s2){
            System.out.println(b);
        }
    }
}
