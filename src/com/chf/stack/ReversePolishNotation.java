package com.chf.stack;

import com.chf.stack.Stack;

/**
 * 逆波兰表达式问题
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        //中缀表达式3 * (17-15)+18/6的逆波兰表达式如下
        String[] arr = {"3","17","15","-","*","18","6","/","+"};
        System.out.println("逆波兰表达式的结果为： "+calculate(arr));
    }

    /**
     * @param arr 逆波兰表达式的数组表达方式
     * @return 逆波兰表达式的计算结果
     */
    public static int calculate(String[] arr){
        //1、定义一个栈，用来存储操作数
        Stack<Integer> oprands = new Stack<>();
        //2、从左往右遍历逆波兰表达式，得到每一个元素
        for(int i = 0;i < arr.length;i++){
            String curr = arr[i];
            Integer o1,o2,o;
            //3、判断当前元素是运算符还是操作数
            switch (curr){
                //4、运算符，从栈中弹出两个操作数，完成运算，运算完的结果再压入栈中
                case "+":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    o = o1 + o2;
                    oprands.push(o);
                    break;
                case "-":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    o = o2 - o1;
                    oprands.push(o);
                    break;
                case "*":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    o = o1 * o2;
                    oprands.push(o);
                    break;
                case "/":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    o = o2 / o1;
                    oprands.push(o);
                    break;
                default:
                    //5、操作数，把该操作数压入栈中，将字符串转换成数字
                    oprands.push(Integer.parseInt(curr));
                    break;
            }
        }
        //6、得到栈中最后一个元素就是逆波兰表达式的结果
        return oprands.pop();
    }
}
