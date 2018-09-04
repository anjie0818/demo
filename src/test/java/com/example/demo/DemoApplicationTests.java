package com.example.demo;




import com.example.demo.dao.*;
import com.example.demo.domain.*;

import com.example.demo.mapper.UserMapper;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.EmailService;
import com.example.demo.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DemoApplicationTests {

	private MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	@Autowired
	PersonDao personDao;
	String expectJson;
	@Before
	public void setup() throws JsonProcessingException {
		Person person1=new Person("anjie","password",34);
		Person person2=new Person("anjie2","password2",24);
		personDao.save(person1);
		personDao.save(person2);
		expectJson=Object2Json(personDao.findAll());
		mvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}
	protected String Object2Json(Object obj) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
	@Test
	public void testPersonController() throws Exception {
		String uri="/persons";
		MvcResult result=mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("错误，正确的返回值为200",200,status);
		Assert.assertEquals("错误，返回值和预期返回值不一致",expectJson,content);

	}


}
