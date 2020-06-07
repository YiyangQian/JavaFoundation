package com.yiyang.concurrency.eight;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * same runnable object shared among threads
 * the attribute of runnable startDate will be modified by all threads
 */
public class UnsafeTask implements Runnable {
    private volatile Date startDate;

    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread: %s : %s\n",
                Thread.currentThread().getId(),startDate);
        try {
            TimeUnit.SECONDS.sleep( (int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",
                Thread.currentThread().getId(),startDate);
    }

    public static void main(String[] args) {
        UnsafeTask unsafeTask = new UnsafeTask();
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(unsafeTask).start();
        }
    }
}
