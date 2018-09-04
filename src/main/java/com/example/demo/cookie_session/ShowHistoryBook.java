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
public class ShowHistoryBook {
    @RequestMapping(value = "/book/list",method = RequestMethod.GET)
    public void showBooks(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("本网站有以下好书：<br/>");
        Map<Integer, Book> books = DBUtil.findAllBooks();
        for (Map.Entry<Integer, Book> book : books.entrySet()) {
            out.write("<a href='"+request.getContextPath()+"/book/showBookDetail?id="+book.getKey()+"' target='_blank'>"+book.getValue().getBookname()+"</a><br/>");
        }
        out.write("本网站浏览记录：<br/>");
        Cookie[] cks = request.getCookies();
        String string="";
        for (int i=0;cks!=null&&i<cks.length;i++){
            if (cks[i].getName().equals("historyBooks")){
                string=cks[i].getValue();
            }
        }
        if (string!=null&&string.length()!=0){
            String[] arrStr=string.split("-");
            for (int i=0;i<arrStr.length;i++){
                Integer id=Integer.parseInt(arrStr[i]);
                out.print(DBUtil.findBookById(id).getBookname()+"</br>");
            }
        }

    }
    @RequestMapping(value = "/book/showBookDetail",method = RequestMethod.GET)
    public void showDetail(HttpServletResponse response,HttpServletRequest request) throws IOException {
        String id = request.getParameter("id");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Book book = DBUtil.findBookById(Integer.parseInt(id));
        out.print(book);
        //处理ID
        id=doHistroyCookie(request,id);
        //创建cookie
        Cookie cookie=new Cookie("historyBooks",id);
        cookie.setPath("/");
        cookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookie);
    }

    private String doHistroyCookie(HttpServletRequest request, String id) {
        Cookie[] cks = request.getCookies();
        //cookie不存在
        if (cks==null){
            return id;
        }
        Cookie cookie = null;
        for (int i=0;i<cks.length;i++){
            //cookie中存在历史记录
            if(cks[i].getName().equals("historyBooks")){
                cookie=cks[i];
            }
        }
        if (cookie==null){
            return id;
        }
//        cookie中有值
        //截取为数组
        String hisBooks = cookie.getValue();
        String[] arrBooks = hisBooks.split("-");
        //数组变为集合
        LinkedList<String> list = new LinkedList<String>(Arrays.asList(arrBooks));
        if (list.size()<3){
            //id包含
            if(list.contains(id)){
                list.remove(id);
            };
        }else {//123
            if (list.contains(id)){
                list.remove(id);
            }else {
                list.removeLast();
            }
        }
        list.addFirst(id);
        StringBuffer stringBuffer=new StringBuffer();
        //list变为数组
        for (int j=0;j<list.size();j++){
            if(j>0){
                stringBuffer.append("-");
            }
            stringBuffer.append(list.get(j));
        }
        System.out.println(stringBuffer);
        return stringBuffer.toString();
    }
}
 class DBUtil {
    private static Map<Integer, Book> books = new HashMap<Integer, Book>();

    static{
        books.put(1, new Book(1, "金瓶梅", 13f));
        books.put(2, new Book(2, "葵花宝典", 20f));
        books.put(3, new Book(3, "九阴真经", 30f));
        books.put(4, new Book(4, "玉女心经", 10f));
        books.put(5, new Book(5, "乾坤大挪移", 10f));

    }

    //得到所有书
    public static Map<Integer, Book> findAllBooks(){
        return books;
    }

    /**
     * 根据id查找指定的书
     * @param id
     * @return
     */
    public static Book findBookById(Integer id){
        return books.get(id);
    }
}


