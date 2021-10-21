package com.company;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Subscriber implements Runnable {
    private LinkedBlockingQueue<Double> queue;

    public Subscriber(LinkedBlockingQueue<Double> queue) {
        this.queue = queue;
    }

    void subscribe() throws InterruptedException {
        double highestKnownPrice = 0.0;
        Double nextValue;
        while (true) {
            while ((nextValue = queue.poll(3, TimeUnit.SECONDS)) != null) {
                if (nextValue > highestKnownPrice) {
                    highestKnownPrice = nextValue;
                    System.out.println("*** Tick ***");
                    System.out.println("Highest offer: " + highestKnownPrice);
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            subscribe();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
