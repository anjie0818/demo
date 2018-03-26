package com.example.demo.dao;

import com.example.demo.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorDao extends CrudRepository<Author,Integer> {
}
