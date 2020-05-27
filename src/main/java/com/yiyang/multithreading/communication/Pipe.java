package com.yiyang.multithreading.communication;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Pipe {
    public static void main(String[] args) throws IOException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        writer.connect(reader);

        new Thread(new WriterThread(writer)).start();
        new Thread(new ReaderThread(reader)).start();
    }
}

class ReaderThread implements Runnable {
    private PipedReader reader;

    public ReaderThread(PipedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        System.out.println("This is reader");
        int receive;
        try {
            while (true) {
                char c = (char) reader.read();
                if (c != -1) {
                    System.out.println(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class WriterThread implements Runnable {
    private PipedWriter writer;

    public WriterThread(PipedWriter writer) {
        this.writer = writer;
    }

    @Override
    public void run() {
        System.out.println("This is writer");
        try {
            while (true) {
                writer.write("testing data written....");
                writer.flush();
                Thread.sleep(2_000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}