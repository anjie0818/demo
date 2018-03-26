package com.example.demo.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "T_category")
public class Category {

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ky='" + ky + '\'' +
                ", status=" + status +

                '}';
    }

    private static final long serialVersionUID = 7419229779731522702L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String ky;
    private Integer status;
    @OneToMany(mappedBy = "category")
    private Set<ArticleCategory> articleCategoryList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKy() {
        return ky;
    }

    public void setKy(String ky) {
        this.ky = ky;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<ArticleCategory> getArticleCategoryList() {
        return articleCategoryList;
    }

    public void setArticleCategoryList(Set<ArticleCategory> articleCategoryList) {
        this.articleCategoryList = articleCategoryList;
    }
}
