package com.example.demo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Test22_linkedList {
    public static void main(String[] args) {
        List<String> aList=new LinkedList<>();
        List<String> bList=new LinkedList<>();
        aList.add("a");
        aList.add("b");
        aList.add("c");
        bList.add("A");
        bList.add("B");
        bList.add("C");
        bList.add("D");
        //merge
        ListIterator<String> aI = aList.listIterator();
        Iterator<String> bI = bList.iterator();
        while (bI.hasNext()){
            if (aI.hasNext()) aI.next();
            aI.add(bI.next());
        }
        System.out.println(aList);
        //remove
        bI=bList.iterator();
        while (bI.hasNext()){
            bI.next();
            if (bI.hasNext()){
                bI.next();
                bI.remove();
            }
        }
        System.out.println(bList);
        aList.removeAll(bList);
        System.out.println(aList);
    }
}
