package com.example.demo.javaImport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Test19_inner {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, false);
        clock.start();
    }
}
class TalkingClock{
    private int interval;
    private boolean beep;
    public TalkingClock(int interval,boolean beep){
        this.interval=interval;
        this.beep=beep;
    }
    public void start(){
        ActionListener listener=new TimePrinter1();
        Timer timer=new Timer(interval,listener);
        timer.start();
    }
    public class TimePrinter1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("date is"+new Date());
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}