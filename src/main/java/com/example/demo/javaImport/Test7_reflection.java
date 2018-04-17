package com.example.demo.javaImport;

import java.util.Random;

public class Test7_reflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Employee e=new Employee("an",11,2011,11,1);
        //方法一：获取Class对象
        System.out.println(e.getClass().getName());
        //方法二：获取Class对象
        String classname="com.example.demo.javaImport.Employee";
        Class cl = Class.forName(classname);
        System.out.println(cl.getName());
        //方法三：class字段
        System.out.println(Employee.class.getName());
        //使用Class对象创建实例
        String s="java.util.Random";
        Class clr = Class.forName(s);
        Object rIS = clr.newInstance();
        System.out.println(rIS);


    }
}
