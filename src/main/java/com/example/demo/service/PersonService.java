package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;

    public List<Person> getPersonList() {
        return personDao.findAll();
    }

    public Person findPersonById(long id) {
        return personDao.findById(id);
    }

    public void save(Person user) {
        personDao.save(user);
    }

    public void edit(Person user) {
        personDao.save(user);
    }

    public void delete(long id) {
        personDao.delete(id);
    }
    public List<Person> persons(){
        return personDao.findAll();
    }

}
