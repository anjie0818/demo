package com.example.demo.dao;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {
//按照username和price查询
    public List<Book>  findByBooknameStartingWithAndPriceLessThan(String bookname,Float price);
    public List<Book>  findByBooknameEndingWithAndPriceGreaterThan(String bookname,Float price);
    //name in()
    public List<Book>  findByBooknameIn(List<String> booknames);
    @Query("select o from Book o where id=(select max(id) from Book)")
    public Book findBookMaxId();
    @Query("select o from Book o where o.bookname=?1")
    public Book findBookByname(String bookname);
    @Query("select o from Book o where o.id=:id")
    public Book findBookById(@Param("id") Integer id);
    @Query(value = "select count(id) from book ",nativeQuery = true)
    public Integer findCount();
}
