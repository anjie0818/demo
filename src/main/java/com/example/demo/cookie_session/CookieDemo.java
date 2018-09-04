package com.example.demo.cookie_session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Controller
public class CookieDemo {
    @RequestMapping(value = "/ck/d1",method = RequestMethod.GET)
    public void test1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        //返回cookie中的时间
        for (int i=0;cookies!=null&&i<cookies.length;i++){
            if("lastAccessTime".equals(cookies[i].getName())){
                Long l=Long.parseLong(cookies[i].getValue());
                out.write("最后访问时间："+new Date(l).toLocaleString());
            }
        }
//        创建cookie
        Cookie cookie=new Cookie("lastAccessTime",System.currentTimeMillis()+"");
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    @RequestMapping(value = "/ck/d2",method = RequestMethod.GET)
    public void test2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        //返回cookie中的时间
        for (int i=0;cookies!=null&&i<cookies.length;i++){
            if("lastAccessTime".equals(cookies[i].getName())){
                Long l=Long.parseLong(cookies[i].getValue());
                out.write("最后访问时间："+new Date(l).toLocaleString());
            }
        }
    }
    @RequestMapping(value = "/d2",method = RequestMethod.GET)
    public void test3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        //返回cookie中的时间
        for (int i=0;cookies!=null&&i<cookies.length;i++){
            if("lastAccessTime".equals(cookies[i].getName())){
                Long l=Long.parseLong(cookies[i].getValue());
                out.write("最后访问时间："+new Date(l).toLocaleString());
            }
        }
    }
    @RequestMapping(value = "/delete/ck",method = RequestMethod.GET)
    public void test4(HttpServletRequest request, HttpServletResponse response) throws IOException {
            Cookie cookie=new Cookie("lastAccessTime","");
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);

    }
}
