package com.example.demo.javaImport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Test13_interface {
    public static void main(String[] args) {
        NewPerson newPerson1=new NewPerson(1,"anj2ie");
        NewPerson newPerson2=new NewPerson(2,"anj222222ie");
        NewPerson newPerson3=new NewPerson(3,"ajie");
        NewPerson newPerson4=new NewPerson(4,"an2222jie");
        NewPerson[] newPeoples={newPerson1,newPerson3,newPerson4,newPerson2};
        for (NewPerson n:newPeoples
             ) {
            System.out.println(n);
        }
        Arrays.sort(newPeoples);
        for (NewPerson n:newPeoples
                ) {
            System.out.println(n);
        }    }

}
class NewPerson implements Comparable<NewPerson>{
    private int id;
    private String name;

    @Override
    public String toString() {
        return "NewPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public NewPerson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(NewPerson o) {
        //如果想按照字符串长度进行排序
//        return Integer.compare(this.id,o.id);
        return new LengthComparator().compare(this,o);
    }
}
class LengthComparator implements Comparator<NewPerson>{


    @Override
    public int compare(NewPerson o1, NewPerson o2) {
        return o1.getName().length()-o2.getName().length();
    }
}