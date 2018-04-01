package com.example.demo.service;

import com.example.demo.dao.AuthorDao;
import com.example.demo.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorDao authorDao;
    @Transactional
    public void saveAuthor(List<Author> authors ){
        authorDao.save(authors);
    }
}
