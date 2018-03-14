package com.example.demo;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.UserController;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	private MockMvc mvc;
	@Autowired
	private UserMapper UserMapper;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new UserController())
				.build();
	}

	@Test
	public void getHello() throws Exception {
		// 注意：status(),content()要静态导入
		mvc.perform(
				MockMvcRequestBuilders.get("/hello").accept(
						MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World")));

	}

	// 测试mybatis
	@Test
	public void testMybatisSelectAll() {
		List<User> users = UserMapper.getAll();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void testMybatisInsert() {
		User user=new User();
		user.setUsername("anjie");
		user.setPassword("password");
		user.setEmail("2323@qq.com");
		UserMapper.insert(user);
	}

	@Test
	public void testMybatisSelectById() {
		System.out.println(UserMapper.getOne(4L));
	}

	@Test
	public void testMybatisUdpate() {
		User user=new User();
		user.setId(5);
		user.setUsername("anjie");
		user.setPassword("password");
		user.setEmail("2323@qq.com");
		UserMapper.update(user);
	}
}
