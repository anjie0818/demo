package com.example.demo.dao;

import com.example.demo.domain.Article;
import com.example.demo.domain.ArticleVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleDao extends JpaRepository<Article, Integer> {
    Page<ArticleVO> findAllByOrderByStatusDescIdDesc(Pageable pageable);

}
