package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
        @Autowired
        private ArticleService articleService;
        @RequestMapping(value = "/article")
        public  Page listUser(@RequestParam(value = "page",defaultValue = "1") Integer page,
                               @RequestParam(value = "size",defaultValue = "10") Integer size) {
            PageRequest request = new PageRequest(page-1,size);
            Page articleVOPage = articleService.findAll(request);
            return articleVOPage;
        }
    }

