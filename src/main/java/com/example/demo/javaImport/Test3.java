package com.example.demo.javaImport;

import java.util.Random;

public class Test3 {
    public static void main(String[] args) {

    Employee3[] es=new Employee3[3];
    es[0]=new Employee3();
    es[1]=new Employee3(1000.0);
    es[2]=new Employee3("anjie",1111.0);
        for (Employee3 e:es
             ) {
            System.out.println(e);
        }
    }
}
class Employee3{
    @Override
    public String toString() {
        return "Employee3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    private static int nextInt;

    private int id;
    private String name="";
    private double salary;

    static{
        Random generator=new Random();
        nextInt =generator.nextInt(1000);
    }
    {
        id=nextInt;
        nextInt++;
    }
    public Employee3(String n,double s){
        name=n;
        salary=s;
    }
    public Employee3(double s){
        this("Employee3#"+nextInt,s);
    }
    public Employee3(){

    }

}
