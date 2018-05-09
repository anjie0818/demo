package com.example.demo.javaImport;

import java.util.IdentityHashMap;
import java.util.Map;

public class Test29_identityHashMap {
    public static void main(String[] args) {
        Map<Employee,String> map=new IdentityHashMap<>();
        map.put(new Employee("anjie",20,2019,01,01),"anjie");
        map.put(new Employee("anjie",20,2019,01,01),"anjie");
        map.forEach((k,v)-> System.out.println(k+"-"+v));
    }
}
