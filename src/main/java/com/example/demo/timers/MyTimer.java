package com.example.demo.timers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTimer {
	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//每3秒执行一次
    @Scheduled(fixedRate = 3000000)
    public void timerRate() {
        System.out.println(simpleDateFormat.format(new Date()));
    }

    //第一次延迟1秒执行，当执行完后3秒再执行
    @Scheduled(initialDelay = 1000, fixedDelay = 3000000)
    public void timerInit() {
        System.out.println("init : "+simpleDateFormat.format(new Date()));
    }

    //每天23点27分50秒时执行
    @Scheduled(cron = "50 27 23 * * ?")
    public void timerCron() {
        System.out.println("current time : "+ simpleDateFormat.format(new Date()));
    }

}
