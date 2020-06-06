package com.yiyang.concurrency.six;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {
    public static void main(String[] args) {
        Deque<Event> events = new ConcurrentLinkedDeque<>();

        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            new Thread(new TaskWriter(events)).start();
        }

        CleanerTask cleanerTask = new CleanerTask(events);
        cleanerTask.start();
    }
}
