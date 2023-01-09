package com.chf.symbol;

public class OrderSymbolTableTest {
    public static void main(String[] args) {
        OrderSymbolTable<Integer,String> table = new OrderSymbolTable<>();
        table.put(1,"张三");
        table.put(2,"李四");
        table.put(4,"赵六");
        table.put(3,"王五");//用deBug的方式看表内的元素
    }
}
