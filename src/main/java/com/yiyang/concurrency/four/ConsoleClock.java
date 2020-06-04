package com.yiyang.concurrency.four;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ConsoleClock implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10 && !Thread.currentThread().isInterrupted(); i++) {
            System.out.println(Thread.currentThread().getState());
            System.out.println(new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Clock has been interrupted");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConsoleClock consoleClock = new ConsoleClock();
        Thread thread = new Thread(consoleClock);
        thread.start();

        TimeUnit.SECONDS.sleep(5);

        thread.interrupt();
    }
}
