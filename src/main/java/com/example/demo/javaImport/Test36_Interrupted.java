package com.example.demo.javaImport;

public class Test36_Interrupted {
}

class Thread3 extends Thread {
    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("someone interrupted me");
            } else {
                System.out.println("thread is going");
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread3 t = new Thread3();
        t.start();

        Thread.sleep(4000);
        t.interrupt();
    }
}

class Example3 extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Example3 thread=new Example3();
        System.out.println("starting thread...");
        thread.start();
        Thread.sleep(3000);
        System.out.println("askint thread to stop");

        thread.stop=true;
        thread.interrupt();

        Thread .interrupted();

        Thread.sleep(3000);
        System.out.println("stoping application...");
        System.exit(0);
    }

    volatile boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            System.out.println("thread running...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                //接收到一个中段异常，提早终结阻塞状态
                System.out.println("thread interrupted");
            }
        }
        System.out.println("thread exiting under request...");
    }
}