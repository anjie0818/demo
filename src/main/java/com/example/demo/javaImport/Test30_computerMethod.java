package com.example.demo.javaImport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test30_computerMethod {
    public static void main(String[] args) {
        //arraylist算最大值
        List<Integer> aList=new ArrayList<>();
        aList.add(1);
        aList.add(8);
        aList.add(5);
        aList.add(3);
        System.out.println(aList);
        Integer big=aList.get(0);
        for (int i=1;i< aList.size();i++) {
            if (big.compareTo(aList.get(i))<0) {
                big=aList.get(i);
            }
        }
        System.out.println(big);
        //linked list算最大值
        List<Integer> lkList=new LinkedList<>();
        lkList.add(5);
        lkList.add(1);
        lkList.add(3);
        lkList.add(2);
        System.out.println(lkList);
        Iterator<Integer> iterator = lkList.iterator();
        Integer big2=iterator.next();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (big2.compareTo(next)<0){
                big2=next;
            }
        }
        System.out.println(big2);
    }
}
