package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;
    public Page findAll(Pageable pageable) {
        Page articleVOPage = articleDao.findAllByOrderByStatusDescIdDesc(pageable);
        return articleVOPage;
    }
}
