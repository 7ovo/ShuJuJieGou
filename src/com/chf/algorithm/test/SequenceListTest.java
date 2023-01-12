package com.chf.algorithm.test;

import com.chf.linklist.SequenceList;

public class SequenceListTest {
    public static void main(String[] args) {
        //创建顺序表对象
        SequenceList<String> s1 = new SequenceList<>(10);
        //测试插入
        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦迪");
        s1.insert(1,"詹姆斯");
        for(String s : s1){
            System.out.println(s);
        }
        //测试获取
        String result = s1.get(1);
        System.out.println("索引1处的值为："+result);
        //测试删除
        String removeResult = s1.remove(3);
        System.out.println("删除的元素为："+removeResult);
        //测试清空
        s1.clear();
        System.out.println("当前线性表的元素个数为："+s1.length());

        System.out.println("=================================================");

        SequenceList<String> s2 = new SequenceList<>(2);
        s2.insert("张三");
        s2.insert("李四");
        s2.insert("王五");
        s2.insert("赵六");
        s2.insert(2,"七七");
        for(String s : s2){
            System.out.println(s);
        }
    }
}
