package com.yiyang.concurrency.two;

public class PrimeGenerator extends Thread {
    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (isPrime(number)) {
                System.out.println(number + "is Prime number\n");
            }
            if (isInterrupted()) {
                System.out.printf("The Prime Generator has been Interrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long l) {
        for (int i = 2; i * i <= l; i++) {
            if (l % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Thread primeGenerator = new PrimeGenerator();
        primeGenerator.start();

        try {
            Thread.sleep(1_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        primeGenerator.interrupt();

        System.out.printf("Main: Status of the Thread: %s\n", primeGenerator.getState());
        System.out.printf("Main: isInterrupted: %s\n", primeGenerator.isInterrupted());
        System.out.printf("Main: isAlive: %s\n", primeGenerator.isAlive());
    }
}
