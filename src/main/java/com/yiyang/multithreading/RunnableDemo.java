package com.yiyang.multithreading;

public class RunnableDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "New Thread with myRunnable");
        thread.start();

        //Lambda
        Runnable runnable =
                () -> {
                    System.out.println("Lambda Runnable running: " + Thread.currentThread().getName());
                };
        Thread lambdaThread = new Thread(runnable, "New Thread with lambdaRunnable");
        lambdaThread.start();

        runForLoopDemo();
    }

    private static void runForLoopDemo() {
        System.out.println("--- for loop demo starts ---");
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 50; i++) {
            new Thread("thread " + i) {
                @Override
                public void run() {
                    try {
                        Thread.currentThread().sleep(1L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread: " + getName() + " running");
                }
            }.start();
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyThread running: " + Thread.currentThread().getName());
    }
}
