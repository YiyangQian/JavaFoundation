package com.yiyang.concurrency.one;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Calculator implements Runnable {
    @Override
    public void run() {
        long current = 1L;
        long max = 80_000L;
        long numPrimes = 0L;

        System.out.println(String.format("thread '%s': start\n", Thread.currentThread().getName()));

        while (current < max) {
            if (isPrime(current++)) numPrimes++;
        }

        System.out.println(String.format("thread '%s': END. Number of Primes: %d\n", Thread.currentThread().getName(), numPrimes));
    }

    private boolean isPrime(long l) {
        for (int i = 2; i * i <= l; i++) {
            if (l % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);
        System.out.printf("Maximum Priority: %s\n", Thread.MAX_PRIORITY);

        Thread[] threads = new Thread[10];
        Thread.State[] status = new Thread.State[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator());
            if (i % 2 == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Yiyang Thread " + i);
        }

        PrintWriter printWriter = null;
        try {
            FileWriter file = new FileWriter("log.txt");
            printWriter = new PrintWriter(file);
            for (int i = 0; i < 10; i++) {
                printWriter.println("Main: Status of Thread " + i + ": " + threads[i].getState());
                printWriter.flush();
                status[i] = threads[i].getState();
            }

            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean finish = false;
        while (!finish) {
            for (int i = 0; i < 10; i++) {
                if (threads[i].getState() != status[i]) {
                    writeThreadInfo(printWriter, threads[i], status[i]);
                    status[i] = threads[i].getState();
                }
            }
            finish = true;
            for (int i = 0; i < 10; i++) {
                finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
            }
        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n", thread.getId(),
                thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
        pw.flush();
    }
}
