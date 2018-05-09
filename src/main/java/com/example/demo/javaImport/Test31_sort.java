package com.example.demo.javaImport;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Test31_sort {
    public static void main(String[] args) {
        List<Employee> lkList=new LinkedList<>();
        lkList.add(new Employee("anjie11",12.11,2018,01,01));
        lkList.add(new Employee("anjie8",12.13,2018,01,01));
        lkList.add(new Employee("anjie3",12.12,2018,01,01));
        lkList.add(new Employee("anjie4",19.1,2018,01,01));
        lkList.add(new Employee("anjie5",1.1,2018,01,01));
//        Collections.sort(lkList);
//        lkList.sort(Comparator.comparingDouble(Employee::getSalary));
//        倒序
//        lkList.sort(Comparator.reverseOrder());
//          lkList.sort(Comparator.comparing(Employee::getName).reversed());
        for (Employee e:lkList
             ) {
            System.out.println(e);
        }
    }
}
