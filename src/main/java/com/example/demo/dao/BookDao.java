package com.example.demo.dao;

import com.example.demo.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDao extends CrudRepository<Book,Integer> {
}
