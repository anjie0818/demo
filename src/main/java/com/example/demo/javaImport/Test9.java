package com.example.demo.javaImport;

import java.lang.reflect.Field;

public class Test9 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        Employee employee=new Employee("anjie",11.11,2018,01,01);
        Class cl = employee.getClass();
        Field field = cl.getDeclaredField("name");
        field.setAccessible(true);
        field.set(employee,"anjie2");
        Object name = field.get(employee);
        System.out.println(name);
    }
}
