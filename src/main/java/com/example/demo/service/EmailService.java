package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class EmailService  {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSender mailSender;
    @Value("${mail.fromMail.addr}")
    private String from;
    public void sendSimpleMail(String to, String subject, String content)throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
        logger.error("发送简单邮件成功");
    }
    public void sendHtmlMail(String to, String subject, String content) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        String content1="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                content+
                "</body>\n" +
                "</html>";
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content1, true);

            mailSender.send(message);
            logger.info("html邮件发送成功");
        } catch (Exception e) {
            logger.error("发送html邮件时发生异常！", e);
            throw e;
        }
    }


    public void sendFileMail(String to, String subject, String content, MultipartFile file) throws Exception{

        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            //将file转为正式的file
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get("pic\\"+file.getOriginalFilename());
            Files.write(path, bytes);
            FileSystemResource fileSystemResource = new FileSystemResource(new File("pic\\"+file.getOriginalFilename()));
            helper.addAttachment(file.getOriginalFilename(), fileSystemResource);

            mailSender.send(message);
            logger.info("带附件的邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送带附件的邮件时发生异常！", e);
            throw e;
        }
    }
}
