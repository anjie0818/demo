package com.example.demo.javaImport;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test37_bankTest {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        //多个线程随机的将钱从一个账号转移到另一个账号
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);

                        Thread.sleep((int) (DELAY * Math.random()));

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}

class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }
    private Lock bankLock=new ReentrantLock();
    private Condition sufficientFunds;
    public void transfer(int from, int to, double amount) throws InterruptedException{
        bankLock.lock();
        try{
        if (accounts[from] < amount)
            //将线程放入等待集中；
            sufficientFunds.await();
        System.out.print("**"+Thread.currentThread()+"** ");
        accounts[from] -= amount;
        System.out.print("from:"+from+"  to:"+to+" 转移了： "+amount+"  ");
        accounts[to] += amount;
        System.out.printf("total balance:%10.2f%n", getTotalBalance());
        //解除该条件下等待集中所有线程的阻塞状态
        sufficientFunds.signalAll();
        }
        finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance() {
        double sum = 0;
        for (double a : accounts)
            sum += a;
        return sum;
    }

    public int size() {
        return accounts.length;
    }

}