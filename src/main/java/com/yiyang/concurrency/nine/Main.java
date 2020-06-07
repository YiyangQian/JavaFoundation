package com.yiyang.concurrency.nine;

public class Main {
    public static void main(String[] args) {
        int numOfThreads = Runtime.getRuntime().availableProcessors() * 2;
        MyThreadGroup myThreadGroup = new MyThreadGroup("myThreadGroup");
        Task task = new Task();

        for (int i = 0; i < numOfThreads; i++) {
            new Thread(myThreadGroup, task).start();
        }

        System.out.printf("Number of Threads: %d\n", myThreadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        myThreadGroup.list();

        Thread[] threads = new Thread[myThreadGroup.activeCount()];
        myThreadGroup.enumerate(threads);
        for (int i = 0; i < myThreadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }
    }
}
