package com.example.demo.javaImport;

import java.util.Date;
import java.util.GregorianCalendar;

public class Test1 {
    public static void main(String[] args) {
        Employee harry = new Employee("harry", 10000, 2015, 10, 30);
        Date d = harry.getSalaryDate();
        d.setTime(d.getTime()-1000000);
        System.out.println("--"+harry.getSalaryDate());

    }
}
class  Employee{
    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    private  String name;
    private double salary;
    private Date salaryDate;
    public Employee(String name, double salary, int year, int month, int day){
        this.name = name;
        this.salary = salary;
        GregorianCalendar Calendar = new GregorianCalendar(year,month,day);
        salaryDate = Calendar.getTime();
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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", salaryDate=" + salaryDate +
                '}';
    }
}
