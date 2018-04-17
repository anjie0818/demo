package com.example.demo.javaImport;

import java.lang.reflect.*;
import java.util.ArrayList;

public class Test10 {
    public static void main(String[] args) {
        Employee e=new Employee("anjie",111,2018,01,01);
        System.out.println(new ObjectAnalyzer().toString(e));
    }
}
class ObjectAnalyzer{
    private ArrayList<Object> visited=new ArrayList<>();
    public String toString(Object obj){
        if (obj==null) return  null;
        if (visited.contains(obj))return "...";
//        将显示参数添加到集合中
        visited.add(obj);
//        获取显示参数的类对象
        Class cl = obj.getClass();
//        判断类对象是否是显示参数
        if (cl==String.class) return (String)obj;
//        判断类对象是否是数组
        if (cl.isArray()){
//          返回表示此类组件类型的 Class
            String r=cl.getComponentType()+"[]{";
            for (int i=0;i< Array.getLength(obj);i++){
                if (i>0) r+=",";
                Object val=Array.get(obj,i);
//                isPrimitive是否是基本类型
                if (cl.getComponentType().isPrimitive()) r+=val;
                else r+=toString(val);
            }
            return r+"}";
        }
        String r=cl.getName();
        do {
            r+="[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields,true);
            for (Field f:fields
                 ) {
                if (!Modifier.isAbstract(f.getModifiers()))
                {
                    if(!r.endsWith("[")) r+=",";
                    r+=f.getName()+"=";
                    try {
                        Class t=f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive()) r+=val;
                        else r+=toString(val);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            r+="]";
            cl=cl.getSuperclass();
        }
        while (cl!=null);
    return  r;
    }



}
