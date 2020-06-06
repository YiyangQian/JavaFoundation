package com.yiyang.concurrency.five;

/**
 * join(): It will put the current thread on wait until the thread on which it is called is dead.
 * If thread is interrupted then it will throw InterruptedException.
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
