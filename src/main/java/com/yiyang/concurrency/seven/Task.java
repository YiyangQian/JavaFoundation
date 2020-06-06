package com.yiyang.concurrency.seven;

public class Task implements Runnable {
    @Override
    public void run() {
        Integer.parseInt("XXX");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
