package com.yiyang.concurrency.six;

import java.util.Date;
import java.util.Deque;

public class CleanerTask extends Thread {
    private Deque<Event> events;

    public CleanerTask(Deque<Event> events) {
        this.events = events;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            cleanUpEventsOlderThan(date, 10);
        }
    }

    private void cleanUpEventsOlderThan(Date date, int seconds) {
        boolean deleted = false;
        while (date.getTime() - events.getFirst().date.getTime() > seconds * 1_000) {
            deleted = true;
            Event removed = events.removeFirst();
            System.out.println("removed latest event: " + removed.date + " " + removed.eventDetail + " " + date) ;
        }
        if (deleted) {
            System.out.println("deletion happened, current size: " + events.size());
        }
    }
}
