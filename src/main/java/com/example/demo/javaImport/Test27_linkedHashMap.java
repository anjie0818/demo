package com.example.demo.javaImport;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Test27_linkedHashMap {
    private static final int MAX_ENTRIES = 5;

    public static void main(String[] args) {
        LinkedHashMap lhm = new LinkedHashMap(MAX_ENTRIES + 1, .75F, false) {

            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_ENTRIES;
            }
        };
        lhm.put(0, "H");
        lhm.put(1, "E");
        lhm.put(2, "L");
        lhm.put(3, "L");
        lhm.put(4, "O");
        lhm.put(5,"s");

        System.out.println("" + lhm);

    }
}
