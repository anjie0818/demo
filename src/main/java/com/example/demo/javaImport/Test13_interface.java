package com.example.demo.javaImport;

import java.util.ArrayList;
import java.util.Arrays;

public class Test13_interface {
    public static void main(String[] args) {
        NewPerson newPerson1=new NewPerson(1,"anjie");
        NewPerson newPerson2=new NewPerson(2,"anjie");
        NewPerson newPerson3=new NewPerson(3,"anjie");
        NewPerson newPerson4=new NewPerson(4,"anjie");
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
        return Integer.compare(this.id,o.id);
    }
}
