package com.example.demo.javaImport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
        System.out.println("test");
        student s=new student();
        InvocationHandler handler=new MyHandler(s);
        PersonIn proxy= (PersonIn)Proxy.newProxyInstance(s.getClass().getClassLoader(),s.getClass().getInterfaces(),handler);
        proxy.doSomething();
    }
}
class MyHandler implements InvocationHandler {
    private  Object target;

    public MyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("上学");
        method.invoke(target,args);
        return null;
    }
}
class student implements PersonIn{

    @Override
    public void doSomething() {
        System.out.println("学生上课");
    }
}
interface PersonIn{
    public void doSomething();
}