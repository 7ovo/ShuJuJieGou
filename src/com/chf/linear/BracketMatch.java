package com.chf.linear;

import com.chf.stack.Stack;

/**
 * 括号匹配问题
 */
public class BracketMatch {
    public static void main(String[] args) {
        String s1 = "(a(a)a";
        System.out.println(s1+" 中的括号是否匹配 "+isMatch(s1));//false
        String s2 = "(aa)a";
        System.out.println(s1+" 中的括号是否匹配 "+isMatch(s2));//true
        String s3 = "(a(a)()a";
        System.out.println(s1+" 中的括号是否匹配 "+isMatch(s3));//false
    }

    /**
     * 判断str中的括号是否匹配
     * @param str 括号组成的字符串
     * @return 如果匹配成功返回true，反之返回false
     */
    public static boolean isMatch(String str){
        //1、创建栈对象，用来存储左括号
        Stack<String> chars = new Stack<>();
        for(int i = 0;i < str.length();i++) {
            String currChar = str.charAt(i) + "";
            //2、从左往右遍历字符串，将左括号放入栈中
            if (currChar.equals("(")) {
                chars.push(currChar);
            } else if (currChar.equals(")")) {
                //3、继续判断当前字符是否有右括号，如果是就弹出一个左括号，并判断弹出是否为null。如果为null则证明没有匹配的左括号
                String pop = chars.pop();
                if (pop == null) return false;
            }
        }
        //4、判断栈中还有没有剩余的左括号，如果有则证明括号不匹配
        if(chars.size() == 0){
            return true;
        }else {
            return false;
        }
    }
}
