package com.example.demo.javaImport;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test8 {
    public static void main(String[] args) throws ClassNotFoundException {
        String className="java.lang.Double";
        Class cl = Class.forName(className);
        //超类
        Class supercl = cl.getSuperclass();
        //找类修饰符
        String modefiers = Modifier.toString(cl.getModifiers());
        if (modefiers.length()>0) System.out.print(modefiers+" ");
        System.out.print("class "+className);
        //找超类
        if (supercl!=null&&supercl!=Object.class) System.out.print(" extends "+supercl.getName());
        System.out.print("\n{\n");
        //构造
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
        System.out.println("}");
    }

    private static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field f:fields
             ) {
            //找字段对应的类
            Class type = f.getType();
            String name=f.getName();
            System.out.println("    ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.println(type.getName()+" "+name+";");
        }
    }

    private static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        for (Method m:methods
             ) {
            Class retType = m.getReturnType();
            String name=m.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.print(retType.getName()+" "+name+"(");
            Class[] paramTypes = m.getParameterTypes();
            for (int j=0;j<paramTypes.length;j++){
                if (j>0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    private static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c:constructors
             ) {
            String name=c.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length()>0){
                System.out.print(modifiers+" ");
            }
            System.out.print(name+"(");
            Class[] paramTypes = c.getParameterTypes();
            for (int j=0;j<paramTypes.length;j++){
                if (j>0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

}
