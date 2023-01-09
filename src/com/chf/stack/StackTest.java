package com.chf.stack;

import com.chf.stack.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        for(String item : stack){
            System.out.print(item+" ");
        }
        System.out.println();
        String result = stack.pop();
        System.out.println("弹出的第一个元素为："+result);
        System.out.println("剩下的元素为："+stack.size());

    }
}
