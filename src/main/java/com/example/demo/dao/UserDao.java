package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;

@Controller
public class UserDao {
	@Autowired
	private UserMapper userMapper;
	public List<User> selectAll(){
		return userMapper.getAll();
	}
}
