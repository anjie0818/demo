package com.example.demo.javaImport;

import java.util.Date;
import java.util.GregorianCalendar;

public class Test16_clone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee16 original=new Employee16("anjie",100,2016,01,01);
        Employee16 copy=original.clone();
        copy.raiseSalary(10);
        System.out.println(original.getSalary());
    }
}

class Employee16 implements  Cloneable {
    private String name;
    private double salary;
    private Date salaryDate;
    public Employee16 clone() throws CloneNotSupportedException {
        Employee16 clone = (Employee16) super.clone();
        return  clone;
    }

    public Employee16(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        GregorianCalendar Calendar = new GregorianCalendar(year, month, day);
        salaryDate = Calendar.getTime();
    }
    public  void raiseSalary(double byPercent){
        double d=salary*byPercent/100;
        salary=salary+d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getSalaryDate() {
        return (Date) salaryDate.clone();
    }

    public void setSalaryDate(Date salaryDate) {
        this.salaryDate = salaryDate;
    }
}