package com.yiyang.multithreading;

public class ChildThreadDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        ChildThread childThread = new ChildThread();
        childThread.start();
    }
}

class ChildThread extends Thread {
    @Override
    public void run() {
        System.out.println("childThread running: " + Thread.currentThread().getName());

    }
}
