package com.example.demo.javaImport;

import org.apache.catalina.Manager;

import java.time.LocalDate;

public class Test4 {
    public static void main(String[] args) {
        Manager4 boos=new Manager4("boos",10000.0,5000.0,2018,01,30);
        Emoloyee4[] emoloyee4s=new Emoloyee4[2];
        emoloyee4s[0]=boos;
        emoloyee4s[1]=new Emoloyee4("emo",10000,2018,02,9);
        for (Emoloyee4 e:emoloyee4s
             ) {
            System.out.println(e.getSalary()+"----"+e.getName());
        }
    }
}
class Emoloyee4{
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Emoloyee4(String name, double salary, int year,int mouth,int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year,mouth,day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }
    public void raiseSalary(double byPercent){
        double raise=salary*byPercent/100;
        salary+=raise;
    }
}
class Manager4 extends Emoloyee4{
    private double bonus;
    public Manager4(String name, double salary,double bonus, int year,int mouth,int day){
        super(name,salary,year,mouth,day);
        this.bonus=bonus;
    }
    public double getSalary() {
        return bonus+super.getSalary();
    }
}
