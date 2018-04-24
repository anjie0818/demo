package com.example.demo.javaImport;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test18 {
    public static void main(String[] args) {
        System.out.println("---------");
        ArrayList<String> names= new ArrayList<>() ;
        names.add("anjie");
        names.add("anjie1");
        names.add("anjie3");
        Stream<Employee> stream = names.stream().map(Employee::new);
        List<Employee> people = stream.collect(Collectors.toList());
        for (Employee e:people
             ) {
            System.out.println(e);
        }
    }
}

