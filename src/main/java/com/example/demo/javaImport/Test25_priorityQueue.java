package com.example.demo.javaImport;

import java.time.*;
import java.util.PriorityQueue;

public class Test25_priorityQueue {
    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq=new PriorityQueue<>();
        pq.add(LocalDate.of(1906,12,9));
        pq.add(LocalDate.of(1901,12,12));
        pq.add(LocalDate.of(1902,12,12));
        pq.add(LocalDate.of(1999,01,01));
        System.out.println("Iterating...");
        for (LocalDate l:pq
             ) {
            System.out.println(l);
        }
        System.out.println("removing...");
        while (!pq.isEmpty())
            System.out.println(pq.remove());
    }
}
