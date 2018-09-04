package com.example.demo.cookie_session;

import com.example.demo.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
public class ShowBookCart {
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public void showBooks(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("本网站有以下好书：<br/>");
        Map<Integer, Book> books = DBUtil.findAllBooks();
        for (Map.Entry<Integer, Book> book : books.entrySet()) {
            out.write("<a href='" + request.getContextPath() + "/books/showBookDetail?id=" + book.getKey() + "' target='_blank'>" + book.getValue().getBookname() + "</a><br/>");
        }
        out.write("本网站购物车：<br/>");
        out.write("<a href='" + request.getContextPath() + "/books/cart' target='_blank'>跳转</a>");


    }
    @RequestMapping(value = "/books/cart" ,method = RequestMethod.GET)
    public void docart(HttpServletResponse response, HttpServletRequest request) throws IOException {
        List<Book> books = (List<Book>) request.getSession().getAttribute("cartName");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (books==null){
            out.print("没有书");
        }else {
            for (Book b :
                    books) {
                out.print(b.getBookname()+"</br>");
            }
        }


    }
    @RequestMapping(value = "/books/showBookDetail", method = RequestMethod.GET)
    public void showDetail(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String id = request.getParameter("id");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Book book = DBUtil.findBookById(Integer.parseInt(id));
        out.print(book);
        //将数据添加到购物车
        List<Book> cart = (List<Book>) request.getSession().getAttribute("cartName");
        if (cart == null) {
            cart = new ArrayList<>();
            cart.add(book);
            request.getSession().setAttribute("cartName", cart);
            return;
        }
        cart.add(book);
    }

}