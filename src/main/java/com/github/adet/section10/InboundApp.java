package com.github.adet.section10;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InboundApp {

    private static final int NUMBER_OF_TASKS = 10_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to start");
        scanner.nextLine();
        System.out.printf("Running %d tasks\n", NUMBER_OF_TASKS);

        long start = System.currentTimeMillis();
        performTasks();
        System.out.printf("Tasks took %dms to complete\n", System.currentTimeMillis() - start);
    }

    private static void performTasks() {
//        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(1_000)) {
            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
                executorService.submit(() -> {
//                    for (int j = 0; j < 100; j++) {
//                        blockingIOOperation();
//                    }
                    blockingIOOperation();
                });
            }
        }
    }

    private static void blockingIOOperation() {
        System.out.println("Executing a blocking task from thread: " + Thread.currentThread());
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
