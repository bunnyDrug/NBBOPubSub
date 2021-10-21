package com.company;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

    class Publisher implements Runnable {

        private LinkedBlockingQueue<Double> queue;
        private static final double lowerBounds = 0.00;
        private static final double upperBounds = 500.00;

        public Publisher(LinkedBlockingQueue<Double> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {

                var nextRandDouble = ThreadLocalRandom.current()
                        .nextDouble(lowerBounds, upperBounds);

                queue.add(nextRandDouble);
//                System.out.println("Queue Size: " + queue.size());
            }
        }
    }


