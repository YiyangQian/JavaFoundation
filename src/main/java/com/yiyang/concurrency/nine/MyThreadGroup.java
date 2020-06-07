package com.yiyang.concurrency.nine;

public class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name) {
        super(name);
    }

    public MyThreadGroup(ThreadGroup parent, String name) {
        super(parent, name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("The thread %s has thrown an Exception\n", t.getName());
        e.printStackTrace(System.out);
        System.out.printf("Terminating the rest of the Threads\n");
        //Interrupts all threads in this thread group.
        interrupt();
    }
}
