package com.github.adet.section2;

public class HandleError {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            throw new RuntimeException("Intentional Exception");
        });

        thread.setName("New Worker Thread");

        thread.setUncaughtExceptionHandler((t, e) -> System.out.println("a critical error happened in thread " + t.getName() + " the error is " + e.getMessage()));

        thread.start();
    }
}
