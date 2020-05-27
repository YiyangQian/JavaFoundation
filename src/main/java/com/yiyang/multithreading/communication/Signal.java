package com.yiyang.multithreading.communication;

public class Signal {
    private static volatile int signal = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (signal < 5) {
                if (signal % 2 == 0) {
                    System.out.println("thread 1 " + signal);
                    synchronized (Signal.class) {
                        signal++;
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (signal < 5) {
                if (signal % 2 == 1) {
                    System.out.println("thread 2 " + signal);
                    synchronized (Signal.class) {
                        signal++;
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
