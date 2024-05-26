package com.github.adet.section11;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadDemo {

    private static final int NUMBER_OF_VIRTUAL_THREAD = 1000;

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> System.out.println("Inside thread: " + Thread.currentThread());

        List<Thread> virtualThreads = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_VIRTUAL_THREAD; i++) {
            Thread virtualThread = Thread.ofVirtual().unstarted(runnable);
            virtualThreads.add(virtualThread);
        }

        for (Thread thread : virtualThreads) {
            thread.start();
        }

        for (Thread thread : virtualThreads) {
            thread.join();
        }
    }
}
