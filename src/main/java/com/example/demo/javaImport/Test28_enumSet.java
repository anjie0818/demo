package com.example.demo.javaImport;

import java.util.EnumMap;
import java.util.EnumSet;

public class Test28_enumSet {
    public static void main(String[] args) {
        EnumSet<WeekDay> always=EnumSet.allOf(WeekDay.class);
        EnumSet<WeekDay> never=EnumSet.noneOf(WeekDay.class);
        EnumSet<WeekDay> workday=EnumSet.range(WeekDay.MONDAY,WeekDay.FRIDAY);
        EnumSet<WeekDay> mwf=EnumSet.of(WeekDay.MONDAY,WeekDay.WEDNESDAY,WeekDay.FRIDAY);
        EnumMap<WeekDay,Employee> personInCharge=new EnumMap<WeekDay, Employee>(WeekDay.class);
        personInCharge.put(WeekDay.FRIDAY,new Employee("anjie1",11.1,2018,01,01));
        personInCharge.put(WeekDay.WEDNESDAY,new Employee("anjie2",11.2,2018,02,02));
        always.forEach(weekDay -> System.out.println(weekDay));
        personInCharge.forEach(((weekDay, employee) -> System.out.println(weekDay+"==="+employee)));

    }
}
enum WeekDay{MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY};
