package com.example.demo.javaImport;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test12 {
    public static void main(String[] args) {
        GregorianCalendar c = (GregorianCalendar) GregorianCalendar.getInstance();
        System.out.println(c.getTime());
        c.add(Calendar.DAY_OF_MONTH,1);
        System.out.println(c.getTime());

    }
}
