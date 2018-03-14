package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	public List<User> findAllUser(){
		return userDao.selectAll();
	}
}
