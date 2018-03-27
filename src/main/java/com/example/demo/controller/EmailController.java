package com.example.demo.controller;

import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;
    @RequestMapping("/cemail/index")
    public String helloIndex(){

        return "/email/index";
    }
    @RequestMapping("/cemail/indexfile")
    public String hellofile(){

        return "/email/indexfile";
    }
    @PostMapping("/cemail/post")
    public String postContent(@RequestParam(value = "subject") String subject,
                              @RequestParam(value = "to") String to,
                              @RequestParam(value = "content") String content, Model model){
        try {
            emailService.sendHtmlMail(to,subject,content);
        } catch (Exception e) {
            model.addAttribute("to","邮箱失败");
            return "/email/success";
        }
        model.addAttribute("to",to);

        return "/email/success";
    }
    @PostMapping("/cemail/postfile")
    public String postContentFile(@RequestParam(value = "subject") String subject,
                              @RequestParam(value = "to") String to,
                              @RequestParam(value = "content") String content,
                                  @RequestParam("file") MultipartFile file,
                                  Model model){
        try {
            emailService.sendFileMail(to,subject,content,file);
        } catch (Exception e) {
            model.addAttribute("to","邮箱失败");
            return "/email/success";
        }
        model.addAttribute("to",to);

        return "/email/success";
    }
}
