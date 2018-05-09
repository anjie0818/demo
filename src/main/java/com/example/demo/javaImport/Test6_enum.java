package com.example.demo.javaImport;

import java.util.Scanner;

public class Test6_enum {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("ENter a size");
        String input= in.next().toUpperCase();
        //返回类实例
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size="+size);
        System.out.println(size.getAbbreviation());
        System.out.println(Size.SMALL.getAbbreviation());
        Size[] values = Size.values();
        for (Size s:values
             ) {
            System.out.println(s.getAbbreviation());
        }

    }
}
enum Size{
    SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LAEGE("XL");
    private String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }

    private Size(String abbreviation){
        this.abbreviation=abbreviation;
    }
}
