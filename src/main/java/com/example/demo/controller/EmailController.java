package com.example.demo.controller;

import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;
    @Autowired
    TemplateEngine templateEngine;
    @RequestMapping("/cemail/index")
    public String helloIndex(){

        return "/email/index";
    }
    @RequestMapping("/cemail/indexfile")
    public String hellofile(){

        return "/email/indexfile";
    }
    @RequestMapping("/cemail/indexpic")
    public String hellopic(){

        return "/email/indexpic";
    }
    @RequestMapping("/cemail/indexdo")
    public String hellodo(){

        return "/email/indexjihuo";
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
    @PostMapping("/cemail/postdo")
    public String postContentFile(@RequestParam(value = "id") String id,
                                  Model model) throws Exception {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", id);
        String emailContent = templateEngine.process("email/emailTemplate", context);
        //发送邮件
        emailService.sendHtmlMail2("1257772358@qq.com","激活",emailContent);
        return "/email/success";}
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
    @PostMapping("/cemail/postpic")
    public String postContentpic(@RequestParam(value = "subject") String subject,
                                  @RequestParam(value = "to") String to,
                                  @RequestParam(value = "content") String content,
                                  @RequestParam("file") MultipartFile file,

                                  Model model){
        //处理rscId   名称
        String rscId=file.getOriginalFilename();
        //处理content
        String content2="<html><body>"+content+"这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        //处理rscPath  全路径
        //流对象先存
        try {
        byte[] bytes = file.getBytes();
        String rscPath="pic\\"+file.getOriginalFilename();
        Path path = Paths.get(rscPath);
        Files.write(path, bytes);
        //流对象取
            emailService.sendInlineResourceMail(to,subject,content2,rscPath,rscId);
        } catch (Exception e) {
            model.addAttribute("to","邮箱失败");
            return "/email/success";
        }
        model.addAttribute("to",to);

        return "/email/success";
    }
}
