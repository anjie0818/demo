package com.example.demo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_article_category")
public class ArticleCategory implements Serializable {
    private static final long serialVersionUID = 7419229779731522702L;
    //查看mysql表主外键关系的表
    //INFORMATION_SCHEMA.KEY_COLUMN_USAGE
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id")
    private Article article;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


}
