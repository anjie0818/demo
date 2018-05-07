package com.example.demo.javaImport;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test24_treeset {
    public static void main(String[] args) {
        SortedSet<Employee> employees=new TreeSet<>();
        employees.add(new Employee("dnjie",1111.1,2011,01,01));
        employees.add(new Employee("cnjie",1114.4,2014,04,04));
        employees.add(new Employee("anjie",1112.2,2012,02,02));
        employees.add(new Employee("bnjie",1113.3,2013,03,03));
        System.out.println(employees);
        System.out.println("-----");
        NavigableSet<Employee> sortByName=new TreeSet<>(Comparator.comparing(Employee::getName));
        sortByName.addAll(employees);
        System.out.println(sortByName);

    }
}
