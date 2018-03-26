package com.example.demo.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "T_article")
public class Article implements Serializable {
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", likeCount=" + likeCount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }

    private static final long serialVersionUID = 7419229779731522702L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Genreated主键生成策略4种，自增
    private Integer id;
    @Lob//文本
    @Column(columnDefinition = "text")
    private String title;
    private String content;
    private Integer userId;
    private Integer likeCount;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    //关联表
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)

    //mappedBy属性值是mapped=“由One的一方指向Many的一方，并且，这个属性应该等于Many的一方中含有One类的属性的属性名，否则会出错啦 ”
    //级联删除：orphanRemoval = true
    private Set<ArticleCategory> articleCategroyList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<ArticleCategory> getArticleCategroyList() {
        return articleCategroyList;
    }

    public void setArticleCategroyList(Set<ArticleCategory> articleCategroyList) {
        this.articleCategroyList = articleCategroyList;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", likeCount=" + likeCount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", articleCategroyList=" + articleCategroyList +
                '}';
    }
}
