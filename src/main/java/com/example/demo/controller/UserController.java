package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import com.example.demo.domain.GirlProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.NeoProperties;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@RestController
// 设置方法中返回数据都是json格式的
public class UserController {
    @Resource
    private GirlProperties girlProperties;
	@Resource 
	private NeoProperties neoProperties;
	@Resource
	private UserService userService;
	@RequestMapping("/userlist")
	public List<User> index() {
        System.out.println(neoProperties.getContent());
		return userService.findAllUser();
	}

    @RequestMapping("/testPro")
    public String testPro() {
        System.out.println(neoProperties.getContent());
        return girlProperties.toString();
    }
}
