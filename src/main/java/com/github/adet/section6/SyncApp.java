package com.github.adet.section6;

import java.util.concurrent.atomic.AtomicInteger;

public class SyncApp {

    public static void main(String[] args) throws InterruptedException {

        InventoryCounter counter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(counter);
        DecrementingThread decrementingThread = new DecrementingThread(counter);

        incrementingThread.start();
        decrementingThread.start();

        incrementingThread.join();
        decrementingThread.join();

        System.out.println("Results : " + counter.getItems());
    }

    public static class IncrementingThread extends Thread {

        private final InventoryCounter counter;

        public IncrementingThread(InventoryCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        }
    }

    public static class DecrementingThread extends Thread {

        private final InventoryCounter counter;

        public DecrementingThread(InventoryCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.decrement();
            }
        }
    }

    private static class InventoryCounter {

        private AtomicInteger items = new AtomicInteger(0);

        public void increment() {
            items.incrementAndGet();
        }

        public void decrement() {
            items.decrementAndGet();
        }

        public int getItems() {
            return items.get();
        }
    }
}
