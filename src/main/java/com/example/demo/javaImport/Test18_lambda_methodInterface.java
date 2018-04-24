package com.example.demo.javaImport;


import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntConsumer;

class Runexp {
    public static void main(String[] args) {
        repectRun(10, (int i) -> {
            System.out.println(i);
        });
        System.out.println("------");
        Employee[] employees = {new Employee("anjie", 1000, 2018, 01, 01),
                new Employee("anjie1", 10001, 2011, 01, 01),
                new Employee("anjie1", 10002, 2011, 01, 01),
                new Employee("anjie2", 10002, 2012, 01, 01)};
        Arrays.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
        System.out.println(Arrays.toString(employees));
    }

    public static void repectRun(int n, IntConsumer intConsumer) {
        for (int i = 1; i <= n; i++) intConsumer.accept(i);
    }

}