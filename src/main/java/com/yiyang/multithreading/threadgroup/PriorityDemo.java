package com.yiyang.multithreading.threadgroup;

import java.util.stream.IntStream;

/**
 * MAX_PRIORITY = 10;
 * MIN_PRIORITY = 1;
 * threads with higher priority have higher chances to get executed earlier
 * os determines exact order while referring to suggested order by jvm
 */
public class PriorityDemo {
    public static void main(String[] args) {
        runThreadsWithPriorities();

    }

    private static void runThreadsWithPriorities() {
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(() -> {
                System.out.println(String.format("current thread name: %s, priority: %d",
                        Thread.currentThread().getName(),
                        Thread.currentThread().getPriority()));
            });
            thread.setPriority(i);
            thread.start();
        });
    }
}
