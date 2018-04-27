package com.example.demo.javaImport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test21_proxy {
    public static void main(String[] args) {
        Transaction t=new Transaction();
        PersonImp personImp=new PersonImp();
        InvocationHandler myhandler=new Myhandler(personImp,t);
        PersonDao personDao = (PersonDao) Proxy.newProxyInstance(personImp.getClass().getClassLoader(), personImp.getClass().getInterfaces(), myhandler);
        personDao.updatePerson();
    }
}

interface PersonDao{
    public void updatePerson();
    public void selectPerson();
}
class PersonImp implements PersonDao{

    @java.lang.Override
    public void updatePerson() {
        System.out.println("updatePerson");
    }

    @java.lang.Override
    public void selectPerson() {
        System.out.println("selectPerson");
    }
}
class Myhandler implements InvocationHandler{
    private Object object;
    private Transaction transaction;
    public Myhandler(Object o,Transaction t){
        this.object=o;
        this.transaction=t;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("updatePerson")) {
            transaction.beginTransaction();
            method.invoke(this.object, args);
            transaction.commitTransaction();
        }
        else method.invoke(this.object,args);
        return null;
    }
}
class Transaction{
    public void beginTransaction(){
        System.out.println("开始事务");
    }
    public void commitTransaction(){
        System.out.println("提交事务");
    }
}