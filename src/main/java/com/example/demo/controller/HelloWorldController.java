package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.NeoProperties;

@RestController
// 设置方法中返回数据都是json格式的
public class HelloWorldController {
	@Resource 
	private NeoProperties neoProperties;

	@RequestMapping("/hello")
	public String index() {
		System.out.println(neoProperties.getTitle() + "---"
				+ neoProperties.getDescription());
		return "Hello World";
	}
}
