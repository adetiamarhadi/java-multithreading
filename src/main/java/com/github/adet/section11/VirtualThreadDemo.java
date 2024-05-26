package com.github.adet.section11;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadDemo {

    private static final int NUMBER_OF_VIRTUAL_THREAD = 100;

    public static void main(String[] args) throws InterruptedException {

        List<Thread> virtualThreads = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_VIRTUAL_THREAD; i++) {
            Thread virtualThread = Thread.ofVirtual().unstarted(new BlockingTask());
            virtualThreads.add(virtualThread);
        }

        for (Thread thread : virtualThreads) {
            thread.start();
        }

        for (Thread thread : virtualThreads) {
            thread.join();
        }
    }

    private static class BlockingTask implements Runnable {

        @Override
        public void run() {
            System.out.println("Inside thread: " + Thread.currentThread() + " before blocking call");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Inside thread: " + Thread.currentThread() + " after blocking call");
        }
    }
}
