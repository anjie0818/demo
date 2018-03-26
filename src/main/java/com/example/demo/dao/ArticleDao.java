package com.example.demo.dao;

import com.example.demo.domain.Article;
import com.example.demo.domain.ArticleVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ArticleDao extends JpaRepository<Article, Integer> {
    Page findAllByOrderByStatusDescIdDesc(Pageable pageable);

    List<Article> findAll();
}
