package com.example.demo.dao;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookDao extends JpaRepository<Book, Integer> {
    @Query("select b.id,b.bookname,a.name,a.age from book b left outer join author a ON b.author_id= a.id")
    Page<BookVo> findByBook(Pageable pageable);

}
