package com.example.demo;




import com.example.demo.controller.ArticleController;
import com.example.demo.dao.*;
import com.example.demo.domain.*;

import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.EmailService;
import com.example.demo.service.PersonService;
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
    @Autowired
	private EmailService emailService;
    @Autowired
	private PersonService personService;
    @Autowired
	private BookService bookService;
    @Autowired
	private AuthorService authorService;
    @Test
	public  void saveAuthor(){
		Author author=new Author();
		author.setId(1);
		author.setAge(11);
		author.setName("aaaaaaa");
		authorDao.save(author);
	}
    @Test
	public void saveAuthorsTest(){
    	Author author=null;
    	List<Author> list=new ArrayList<Author>();
    	for (int i=0;i<10;i++){
    		author=new Author();
    		author.setName("test"+i);
    		author.setAge(i+20);
    		list.add(author);
		}
		authorService.saveAuthor(list);


	}
    @Test
	public void saveBooksTest(){

	List<Book> list =new ArrayList<Book>();
		Author author = new Author();
		author.setName("jina");
		author.setAge(111);
		Book book=null;
		int i=6;
		book=new Book();
		book.setBookname("a55fsf55njie"+i);
		book.setPrice(i+1010);
		book.setAuthor(author);
		bookService.save(book);
	}
    @Test
	public void testBookMaxId(){
		Integer count= bookDao.findCount();
		System.out.println(count);
	}

    @Test
	public void testPerson(){
		List<Person> s = personService.getPersonList();
		for (Person p:s
			 ) {
			System.out.println(s);
		}
	}

	@Test
	public void sendInlineResourceMail() {
		String rscId = "Chrysanthemum.jpg";
		String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
		String imgPath = "F:\\IdeaProjects\\demo\\pic\\Chrysanthemum.jpg";

		emailService.sendInlineResourceMail("1257772358@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
	}
	@Test
	public void test_book() {
		List<String> lists=new ArrayList<String>();
		lists.add("hexin1");
		lists.add("hexin2");
		List<Book> list = bookDao.findByBooknameIn(lists);
		System.out.println(list.size());
		System.out.println("-------");
		int page=0,size=1;
		Pageable pageable = new PageRequest(page, size);
		Page<Book> s = bookDao.findAll(pageable);
		Iterator<Book> ss = s.iterator();
		while (ss.hasNext()) {
			Book ele = ss.next();
			//System.out.println(ele);//Bob  Alice  Lisy
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
