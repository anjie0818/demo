package com.example.demo.dao;

import com.example.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person, Long> {
    Person findById(long id);
    Long deleteById(Long id);

}
