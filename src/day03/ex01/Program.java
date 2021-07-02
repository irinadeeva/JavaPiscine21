package day03.ex01;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Producer implements Runnable {
    private List<String> buffer;
    private int count;

    public Producer(List<String> buffer, int count) {
        this.buffer = buffer;
        this.count = count;
    }

    @Override
    public void run() {

        for (int i = 0; i < count; i++) {
            synchronized (buffer) {
                buffer.add("i");
                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted.");
                }
            }
            System.out.println(Thread.currentThread().getName());
        }
        synchronized (buffer) {
            buffer.add(Program.EOF);
        }
    }
}


class Consumer implements Runnable {
    private List<String> buffer;
    private int count;

    public Consumer(List<String> buffer, int count) {
        this.buffer = buffer;
        this.count = count;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(Program.EOF)) {
                   // System.out.println(Thread.currentThread().getName());
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName());
                    buffer.remove(0);
                    try {
                        Random random = new Random();
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " interrupted.");
                    }
                }
            }
        }
    }
}


public class Program {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("NB! The flag with a number of times is not passed");
            System.exit(0);
        }
        if (!args[0].startsWith("--count=")) {
            System.out.println("NB! The flag is wrong. The right flag is --count=NUMBER");
            System.exit(0);
        }

        int count = 0;
        try {
            count = Integer.parseInt(args[0].substring(args[0].indexOf("=") + 1));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        List<String> buffer = new ArrayList<>();

        Thread producerThread = new Thread(new Producer(buffer, count));
        producerThread.setName("Egg");

        Thread consumerThread = new Thread(new Consumer(buffer, count));
        consumerThread.setName("Hen");

        producerThread.start();
        consumerThread.start();

    }
}
