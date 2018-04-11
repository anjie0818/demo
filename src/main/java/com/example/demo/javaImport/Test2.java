package com.example.demo.javaImport;

public class Test2 {
    public static void main(String[] args) {
        //创建三个对象
        Employee2[] employee2s=new Employee2[3];
        employee2s[0]=new Employee2("anjie1",123.1);
        employee2s[1]=new Employee2("anjie2",123.2);
        employee2s[2]=new Employee2("anjie3",123.3);
        for (Employee2 e:employee2s
             ) {
            e.setId();
            System.out.println(e.getName()+" "+e.getId()+" "+e.getSalary());
        }
        int n=Employee2.getNextId();
        System.out.println("--"+n);
    }
}
class Employee2{
    private static int nextId=1;

    private String name;
    private Double salary;
    private int id;
    //构造
    public Employee2(String name, Double salary) {
        this.name = name;
        this.salary = salary;
        id = 0;
    }
    //更改器方法

    public void setId() {
        id=nextId;
        nextId++;
    }
    public static int getNextId(){
        return nextId;
    }
    //访问器方法
    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
    //测试
    public static void main(String[] args) {
        Employee2 employee2=new Employee2("anjie",1222.0);
        System.out.println(employee2.getName()+" "+employee2.getSalary());
    }
}
