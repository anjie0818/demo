package com.example.demo.javaImport;

import java.util.*;
import java.util.stream.Collectors;

public class Test32_shuffle {
    public static void main(String[] args) {
        List<Integer> numbers=new ArrayList<>();
        for (int i=1;i<=49;i++){
            numbers.add(i);
        }

        System.out.println(numbers.get(Collections.binarySearch(numbers,12)));
        System.out.println("----------------");
        //Collections.shuffle(numbers);
        List<Integer> subNumbers=numbers.subList(0,15);
        Collections.sort(subNumbers);
        for (int i:subNumbers
             ) {
            System.out.println(i);
        }
        System.out.println("==============");
        List<String> list=new ArrayList<>();
        list.add("anjie");
        list.add("tef");
        list.add("sssssss");
        //list.removeIf(w->w.length()<=4);
        list.replaceAll(String::toUpperCase);
        System.out.println(list);

    }
}
