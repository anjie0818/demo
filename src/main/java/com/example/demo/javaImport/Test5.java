package com.example.demo.javaImport;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Test5 {
    public static void main(String[] args) {
        Person[] perple=new Person[2];
        perple[0]=new Employee5("anjie",5000.11,2018,9,12);
        perple[1]=new Student("student","major");
        for (Person p:perple
             ){
            System.out.println(p.getDescription()+"-----"+p.getName());
        }
        Object o=new Object();
        Date date=new Date();
        date.clone();
        String s="ss";
        String ss=new String("ss");
        System.out.println(s);
        System.out.println(ss);
        System.out.println(s==ss);
    }
}
abstract class Person{
    public abstract String getDescription();
    private String name;
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
class Employee5 extends Person{
    private double salary;
    private LocalDate hireDate;
    public Employee5(String name,double salary,int year,int mouth,int day){
        super(name);
        this.salary=salary;
        this.hireDate=LocalDate.of(year,mouth,day);
    }
    public double getSalary() {
        return salary;
    }
    public LocalDate getHireDate() {
        return hireDate;
    }
    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f",salary);
    }
    public void raiseSalary(double byPercent){
        double raise=salary*byPercent;
        salary+=raise;
    }
}
class Student extends Person{
    private String major;
    public Student(String name,String major){
        super(name);
        this.major=major;
    }
    public String getMajor() {
        return major;
    }
    @Override
    public String getDescription() {
        return "a student majoring in "+major;
    }
}