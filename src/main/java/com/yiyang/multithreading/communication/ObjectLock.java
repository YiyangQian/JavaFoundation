package com.yiyang.multithreading.communication;

/**
 * lock is applied to any object
 * threads that need the lock will keep trying to get it
 * and this will wait some resources
 */
public class ObjectLock {
    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 1 " + i);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 2 " + i);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

