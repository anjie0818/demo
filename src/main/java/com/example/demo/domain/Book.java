package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class Book {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int Id;
        private String name;
        private float price;
        @JoinColumn
        @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.EAGER)
        //book与作者是多对一的关系，JoinColumn用来加入外键，Cacade 用来级联，CascadeType.Remove 指级联删除，被关联表元祖删除，关联表的对应元祖也会被删除，这里book是关联表，通过外键字段author(在数据库中为author_id外键）关联author表，author是被关联表
        // 同样 CascadeType.Persist则是级联存储，其他几个 对应他们的本身单词意思
        //CascadType.ALL 则包含了所有级联操作
        private Author author;
        //自动映射到数据库字段为author_id

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
