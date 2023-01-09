package com.chf.test;

import com.chf.linklist.TwoWayLinkList;

public class TwoWayLinkListTest {
    public static void main(String[] args) {
        TwoWayLinkList<String> s1 = new TwoWayLinkList<>();
        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦迪");
        s1.insert(1,"詹姆斯");
        for(String s : s1){
            System.out.println(s);
        }
        String result = s1.get(1);
        System.out.println("索引1处的值为："+result);

        System.out.println("======================================================");

        System.out.println("第一个元素是："+s1.getFirst());
        System.out.println("最后一个元素是："+s1.getLast());

        String removeResult = s1.remove(3);
        System.out.println("删除的元素为："+removeResult);
        s1.clear();
        System.out.println("当前线性表的元素个数为："+s1.length());

    }
}
