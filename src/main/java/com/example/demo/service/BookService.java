package com.example.demo.service;

import com.example.demo.dao.BookDao;
import com.example.demo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;
    @Transactional
    public void save (Book book){
        bookDao.save(book);
    }
}
