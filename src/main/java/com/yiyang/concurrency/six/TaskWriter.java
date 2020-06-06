package com.yiyang.concurrency.six;

import com.sun.xml.internal.ws.util.xml.CDATA;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class TaskWriter implements Runnable {
    Deque<Event> events;

    public TaskWriter(Deque<Event> events) {
        this.events = events;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            Event event = new Event();
            event.date = new Date();
            event.eventDetail = Thread.currentThread().getName();
            events.addLast(event);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
