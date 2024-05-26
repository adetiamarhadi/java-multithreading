package com.github.adet.section11;

public class VirtualThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> System.out.println("Inside thread: " + Thread.currentThread());

        Thread platformThread = new Thread(runnable);

        platformThread.start();
        platformThread.join();
    }
}
