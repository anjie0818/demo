package com.example.demo.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private int age;
    @OneToMany( mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.EAGER )
    //作者与书 是一对多的关系，mappedBy 指的是通过  book表中的author字段来映射，mappedBy一般用来设置为关联表的外键字段，这里Book实体中的外键字段为author，则设置为author,设置为别的字段没法进行连接查询
    private List<Book> books;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
