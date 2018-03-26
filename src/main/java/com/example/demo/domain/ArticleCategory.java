package com.example.demo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_article_category")
public class ArticleCategory implements Serializable {
    private static final long serialVersionUID = 7419229779731522702L;
    @Id
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    @Id
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "ArticleCategory{" +
                "article=" + article +
                '}';
    }
}
