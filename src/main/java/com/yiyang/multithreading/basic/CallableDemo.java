package com.yiyang.multithreading.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * <p>The {@code Callable} interface is similar to {@link
 * java.lang.Runnable}, in that both are designed for classes whose
 * instances are potentially executed by another thread.  A
 * {@code Runnable}, however, does not return a result and cannot
 * throw a checked exception.
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<String>> l = new ArrayList<>();
        Task task = new Task();
        for (int i = 0; i < 100; i++) {
            Future<String> future = executor.submit(task);
            l.add(future);
        }

        while (true) {
            if (l.size() == 0) break;
            Iterator<Future<String>> iterator = l.iterator();
            while (iterator.hasNext()){
                Future<String> future = iterator.next();
                if (future.isDone()) {
                    try {
                        System.out.println(new Date() + " :: " + future.get());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    } finally {
                        iterator.remove();
                    }
                }
            }
        }
        executor.shutdown();
    }
}

class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1_000);
        return Thread.currentThread().getName();
    }
}


