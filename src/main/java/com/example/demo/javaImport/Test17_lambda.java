package com.example.demo.javaImport;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Date;

public class Test17_lambda {
    public static void main(String[] args) {
        String[] array = {"anjie", "aa", "ddddd","z"};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array,(String a,String b)->{return a.length()-b.length();});
        System.out.println(Arrays.toString(array));
        System.out.println("---------");
        Timer t=new Timer(1000,event->{
            System.out.println("time is :"+new Date());
            Toolkit.getDefaultToolkit().beep();
        });
        t.start();
        JOptionPane.showMessageDialog(null,"quit?");
        System.exit(0);
    }
}
