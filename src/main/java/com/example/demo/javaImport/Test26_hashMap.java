package com.example.demo.javaImport;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Test26_hashMap {
    public static void main(String[] args) {
        Map<Integer,Employee> map=new HashMap<>();
        map.put(1,new Employee("anjie1",2001.1,1993,01,01));
        map.put(2,new Employee("anjie2",2001.2,1993,01,01));
        map.put(3,new Employee("anjie3",2001.3,1993,01,01));
        map.forEach ((k,v)-> System.out.println("key:"+k+" "+"val:"+v));
        Set<Integer> tset = map.keySet();
        tset.iterator();
        System.out.println("-----");
        Map<Integer,Integer> map2=new HashMap<>();
        //解决：map2.put(1,map2.get(1)+1);
        //方法一：
        //map2.put(1,map2.getOrDefault(1,0)+1);
        map2.merge(1,2,Integer::sum);
        map2.forEach ((k,v)-> System.out.println("key:"+k+" "+"val:"+v));
        System.out.println("-----");
        //方法二：使用merge
        Set<String> mdnSet1 = new HashSet<>();
        Set<String> mdnSet2 = new HashSet<>();
        Set<String> mdnSet3 = new HashSet<>();
        mdnSet1.add("133");
        mdnSet1.add("153");
        mdnSet2.add("133");
        mdnSet2.add("189");
        mdnSet3.add("133");
        mdnSet3.add("189");

        // 133_LABELA:LABELB:LABELC;153_LABELA;189_LABELC:LABELB
        Map<String, Set<String>> labels = new HashMap<>();
        labels.put("LABELA", mdnSet1);
        labels.put("LABELB", mdnSet2);
        labels.put("LABELC", mdnSet3);
        for (Map.Entry<String,Set<String>> e:labels.entrySet()
             ) {
            System.out.println(e.getKey()+" "+e.getValue());
        }
        System.out.println("---");
        //将建和值互换---
        // 将内容存到map中，号码为key，label为value
        Map<String, String> mdnLabels = new ConcurrentHashMap<>();
        //遍历原map
        for (Map.Entry<String, Set<String>> entry : labels.entrySet()) {
            //原map的value本来就是set
            Set<String> mdnList = entry.getValue();// mdns
            String label = entry.getKey();// label
            for (String mdn : mdnList) {
                if (mdnLabels.get(mdn) == null) {// 首次放入手机号
                    mdnLabels.put(mdn, mdn + "_" + label);
                } else {//其他
                    mdnLabels.merge(mdn, label, (value, newValue) -> value.concat(":" + newValue));//将label中的
                }
            }
        }

        System.out.println(mdnLabels);

    }


}

