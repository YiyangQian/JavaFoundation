package com.yiyang.concurrency.five;

/**
 * join(): It will put the current thread on wait until the thread on which it is called is dead.
 * If thread is interrupted then it will throw InterruptedException.
 *
 * join (long milliseconds)
 * In the first version of the join() method, instead of indefinitely waiting for the finalization of the thread called,
 * the calling thread waits for the milliseconds specified as the parameter of the method.
 * For example, if the object thread1 has thread2.join(1000), thread1 suspends its execution until one of these two conditions are met:
 *  thread2 has finished its execution
 *  1,000 milliseconds have passed
 */
public class Main {
    public static void main(String[] args) {
        Thread dataSourceLoader = new Thread(new DataSourcesLoader());
        Thread networkConnectionLoader = new Thread(new NetworkConnectionsLoader());
        dataSourceLoader.start();

        try {
            dataSourceLoader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        networkConnectionLoader.start();
    }
}
