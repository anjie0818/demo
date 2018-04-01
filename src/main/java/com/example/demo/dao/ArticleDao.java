package com.example.demo.dao;

import com.example.demo.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Article,Integer>{
}
