package com.yiyang.multithreading.threadgroup;

public class Demo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("new thread name: " + Thread.currentThread().getName());
            System.out.println("new thread group name: " + Thread.currentThread().getThreadGroup().getName());
        });
        thread.start();

        System.out.println("Main Thread: " + Thread.currentThread().getName());
        System.out.println("Main Thread: " + Thread.currentThread().getThreadGroup().getName());
    }
}
