package com.yiyang.multithreading.state;

public class BlockedDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "thread2");

        thread1.start();
        thread2.start();
        System.out.println(thread1.getName() + " : " + thread1.getState()); //thread1 : TIMED_WAITING
        System.out.println(thread2.getName() + " : " + thread2.getState()); //thread2 : BLOCKED
    }

    private static synchronized void testMethod() {
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
