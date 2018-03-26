package com.example.demo.dao;

import com.example.demo.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthorDao extends JpaRepository<Author, Integer> {
}
