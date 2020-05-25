package com.yiyang.multithreading.state;

import java.util.concurrent.locks.LockSupport;

/**
 * Thread.State enum 6 status
 * 1. NEW: Thread state for a thread which has not yet started.
 * 2. RUNNABLE: A thread in the runnable state is executing in the Java virtual machine
 *            but it may be waiting for other resources from the operating system
 *            such as processor.
 * 3. BLOCKED: Thread state for a thread blocked waiting for a monitor lock.
 * 4. WAITING: A thread in the waiting state is waiting for another thread to
 *          perform a particular action.
 *          1. Object.wait with no timeout
 *          2. Thread.join with no timeout
 *          3. LockSupport.park
 * 5. TIMED_WAITING: 1. Thread.sleep
 *                2. Object.wait with timeout
 *                3. Thread.join with timeout
 *                4. LockSupport.parkNanos
 *                5. LockSupport.parkUntil
 * 6. TERMINATED: The thread has completed execution.
 */

public class StateDemo {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        LockSupport.parkNanos(thread, 1L);
        System.out.println(thread.getState());
    }
}
