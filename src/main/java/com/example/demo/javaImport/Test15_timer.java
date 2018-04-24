package com.example.demo.javaImport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Test15_timer {
    public static void main(String[] args) {
        ActionListener listener=new TimePrinter();
//
//        Timer timer=new Timer(3000,listener);
        //方法饮用
        Timer timer=new Timer(3000,System.out::println);
        timer.start();
//       显示一条信息和一个OK确认框
        JOptionPane.showMessageDialog(null,"quit program?");
        System.exit(0);
    }
}
class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone,the time is"+new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
