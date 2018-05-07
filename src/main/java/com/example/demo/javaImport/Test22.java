package com.example.demo.javaImport;

import java.util.*;

public class Test22 {
    public static void main(String[] args) {
        List<String> linkedList1=new LinkedList<>();
        linkedList1.add("an1");
        linkedList1.add("an2");
        linkedList1.add("an3");
        List<String> linkedList2=new LinkedList<>();
        linkedList2.add("jie1");
        linkedList2.add("jie2");
        linkedList2.add("jie3");
        linkedList2.add("jie4");
        ListIterator<String> iter1 = linkedList1.listIterator();
        Iterator<String> iter2 = linkedList2.iterator();
        while (iter2.hasNext()){
            if(iter1.hasNext()){
                iter1.next();
            }
            iter1.add(iter2.next());
        }
        System.out.println(linkedList1);
        System.out.println("-----");
        iter2=linkedList2.iterator();
        while (iter2.hasNext()){
            iter2.next();
            if (iter2.hasNext()){
                iter2.next();
                iter2.remove();
            }
        }
        System.out.println(linkedList2);
        linkedList1.removeAll(linkedList2);
        System.out.println(linkedList1);
    }
}
