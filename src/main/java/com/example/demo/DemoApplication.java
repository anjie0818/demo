package com.example.demo;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.scheduling.annotation.EnableScheduling;
@MapperScan("com.example.demo.mapper")
@SpringBootApplication
//定时任务注解
@EnableScheduling
public class DemoApplication implements EmbeddedServletContainerCustomizer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
        System.out.println("anjie");
        System.out.println("anjie");
        System.out.println("anjie");
	}
	@Override
	public void customize(ConfigurableEmbeddedServletContainer arg0) {
		arg0.setPort(8088);
	}
}
