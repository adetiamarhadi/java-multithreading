package com.github.adet.section2;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> System.out.println("we are in a new thread " + Thread.currentThread().getName()));

        System.out.println("we are in thread " + Thread.currentThread().getName() + " before starting a new thread.");

        thread.start();

        System.out.println("we are in thread " + Thread.currentThread().getName() + " after starting new thread.");

        Thread.sleep(2_000);
    }
}
