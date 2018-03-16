package com.example.demo;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.UserController;
import com.example.demo.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	private MockMvc mvc;
	@Autowired
	private UserMapper UserMapper;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void getHello() throws Exception {
		/**
		 * 注意：status(),content()要静态导入 mvc.perform(
		 * MockMvcRequestBuilders.get("/hello").accept(
		 * MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		 * .andExpect(content().string(equalTo("Hello World")));
		 */
	}

}
