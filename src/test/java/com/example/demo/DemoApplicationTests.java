package com.example.demo;




import com.example.demo.controller.ArticleController;
import com.example.demo.dao.*;
import com.example.demo.domain.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.UserController;
import com.example.demo.mapper.UserMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	private MockMvc mvc;
	@Autowired
	private GirlDao girlDao;
	@Autowired

	private ArticleDao articleDao;
	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private BookDao bookDao;
    @Autowired
    private CategoryDao categoryDao;

	@Test
	public void test_book() {
		int page=0,size=1;
		Pageable pageable = new PageRequest(page, size);
		Page<Book> s = bookDao.findAll(pageable);
		Iterator<Book> ss = s.iterator();
		while (ss.hasNext()) {
			Book ele = ss.next();
			System.out.println(ele);//Bob  Alice  Lisy
		}

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
	@Test
	public  void  testGrilDao() {

		for (int i=1 ;i<=50;i++){
		Girl girl = new Girl();
		girl.setAge(i);
		girl.setEmail("2323@qq.com"+i);
		girl.setPassword("password"+i);
		girl.setUsername("anjie"+i);
		//girlDao.save(girl);
		}
		List<Girl> list = girlDao.findByUsernameAndAge("anjie",22);
		for (Girl eleGirl:list){
			System.out.println(eleGirl);
		}
		System.out.println("-----");
		//girlDao.delete(girl);
		System.out.println(girlDao.count());
	}
	@Test
	public void testtestGrilDaoPage(){
		int page=3 ,size=10;
		Sort sort=new Sort(Sort.Direction.DESC,"id");
		Pageable pageable=new PageRequest(page, size, sort);
		Page<Girl> lists = girlDao.findByUsername("anjie", pageable);
		for (Girl g:lists
			 ) {
			System.out.println(g);
		}
	}
	@Test
	public void testGrilDaoPageFirst15() {
		int page = 1, size = 5;
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = new PageRequest(page, size, sort);
		Page<Girl> lists = girlDao.queryFirst4ByUsername("anjie", pageable);
		//每页格式：size对比first?  :siza小：size;size大：取first?
		for (Girl g : lists
				) {
			System.out.println(g);
		}
	}
	@Test
	public void testGrilDaoMySql(){
		//girlDao.modifyByIdAndUsername("anj2111112qqqq22i00e",21);
		//girlDao.deleteById(3);
        //girlDao.findByEmail("2323@qq.com17");
        girlDao.findByEmail("2323@qq.com16");
	}

}
