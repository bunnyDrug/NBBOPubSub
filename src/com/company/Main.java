package com.company;

import java.util.concurrent.LinkedBlockingQueue;


public class Main {
    public static void main(String[] args) {

        LinkedBlockingQueue<Double> queue = new LinkedBlockingQueue<>();

        new Thread(new Publisher(queue)).start();
        new Thread(new Subscriber(queue)).start();
    }
}

