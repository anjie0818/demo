package com.example.demo.javaImport;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Test23_hashset {
    public static void masin(String[] args) {
                Scanner s = new Scanner(System.in); //定义scanner，等待输入
                System.out.println("请输入字符串：");
                while (true) {
                    String line = s.nextLine(); //读取输入内容
                    if (line.equals("exit")) break; //如果读取到exit，则退出输入
                    System.out.println(">>>" + line); //打印输入内容
                }
            }

    public static void main(String[] args) {
        Set<String> words=new HashSet<>();
        long totalTime=0;

        try (Scanner in =new Scanner(System.in)) {
            while (in.hasNextInt()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                System.out.println(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }
        Iterator<String> iterator=words.iterator();
        for (int i=1;i<=20&& iterator.hasNext();i++){
            System.out.println(iterator.next());
        }
        System.out.println("...");
        System.out.println(words.size()+" distinct words "+totalTime+" milliseconds");
    }
}
