package com.example.demo.javaImport;

import java.util.*;

public class Test22 {
    public static void main(String[] args) {
        Queue<String> queue=new LinkedList<>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for (String q:queue
             ) {
            System.out.println(q);
        }
        System.out.println("======");
        System.out.println("poll"+queue.poll());//返回第一个元素并且删除
        for (String q:queue
             ) {
            System.out.println(q);
        }
        System.out.println("======");
        System.out.println("element"+queue.element());//返回第一个元素
        for (String s:queue
             ) {
            System.out.println(s);
        }
        System.out.println("======");
        System.out.println("peek="+queue.peek());//返回第一个元素
        for (String s:queue
             ) {
            System.out.println(s);
        }
        System.out.println("--====----");
        List<String> strings=new LinkedList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.forEach((value-> System.out.println(value)));

    }
}
