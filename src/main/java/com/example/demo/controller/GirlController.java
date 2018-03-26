package com.example.demo.controller;

import com.example.demo.dao.GirlDao;
import com.example.demo.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class GirlController {
@Autowired
    private GirlDao girlDao;
@GetMapping(value="/girls")
    public List<Girl> girls(){
    return  girlDao.findAll();
}
@PostMapping(value = "/girls")
    public Girl addGirl(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        @RequestParam("email")String email,
                        @RequestParam("age")Integer age
                        ){
    Girl girl = new Girl();
    girl.setUsername(username);
    girl.setPassword(password);
    girl.setEmail(email);
    girl.setAge(age);
    return girlDao.save(girl);
}
//按照id查询
    @GetMapping(value = "/girl/{id}")
    public Girl findbyid(@PathVariable("id")Integer id){
    return girlDao.findOne(id);
    }
    //更新
    @PutMapping(value="/girls/{id}")
    public Girl updateGirl (@PathVariable("id")Integer id,
                            @RequestParam("username")String username,
                            @RequestParam("password")String password,
                            @RequestParam("email")String email,
                            @RequestParam("age")Integer age
                      ){
        System.out.println("id"+id);
        Girl girl = new Girl();
        girl.setUsername(username);
        girl.setId(id);
        girl.setPassword(password);
        girl.setEmail(email);
        girl.setAge(age);
    return girlDao.save(girl);
    }
    @DeleteMapping(value = "/girl/{id}")
    public Girl delete (@PathVariable("id")Integer id){
        girlDao.deleteById(id);
    return null;
    }
    //事务处理，同时插入两条
    @Transactional
    @GetMapping(value="/girl/two")
        public void insetTwo(){
        Girl girl1=new Girl();
        Girl girl2=new Girl();
        girl1.setUsername("anjie");
        girlDao.save(girl1);
        int a=4/0;
       girl2.setUsername("anjie2");
       girlDao.save(girl2);

    }
}
