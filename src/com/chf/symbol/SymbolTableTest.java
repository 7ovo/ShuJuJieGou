package com.chf.symbol;

public class SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<Integer,String> symbolTable = new SymbolTable<>();
        symbolTable.put(1,"张三");
        symbolTable.put(2,"李四");
        symbolTable.put(3,"王五");
        System.out.println("符号表的长度为：" + symbolTable.size());//3
        symbolTable.put(3,"呵呵");
        System.out.println("符号表的长度为：" + symbolTable.size());//3
        symbolTable.delete(1);
        System.out.println("符号表的长度为：" + symbolTable.size());//2
        String s = symbolTable.get(3);
        System.out.println("获取到的元素为：" + s);//呵呵
    }
}
