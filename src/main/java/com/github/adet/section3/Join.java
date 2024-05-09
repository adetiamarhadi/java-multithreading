package com.github.adet.section3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Join {

    public static void main(String[] args) throws InterruptedException {

        List<FactorialThread> threads = new ArrayList<>();

        List<Long> inputNumbers = Arrays.asList(0L, 3435L, 35435L, 2324123L, 4656L, 23L, 5556L);
        for (long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }

        /**
         * you can play with comment thread.setDaemon(true);
         * and comment thread.join(2_000);
         * try to run it to understand how it used!
         */

        for (Thread thread : threads) {
            thread.setDaemon(true);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join(2_000);
        }

        for (int i = 0; i < inputNumbers.size(); i++) {

            System.out.println("Waiting for thread index: " + i);
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress");
            }
            System.out.println("Done thread index: " + i + " ; with input number " + factorialThread.inputNumber);
        }
    }

    public static class FactorialThread extends Thread {

        private final long inputNumber;

        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            System.out.println("Starting count factorial: " + inputNumber);
            this.result = factorial(inputNumber);
            this.isFinished = true;
            System.out.println("Finished count factorial: " + inputNumber);
        }

        public BigInteger factorial(long n) {
            BigInteger tempResult = BigInteger.ONE;

            for (long factor = 2; factor <= n; factor++) {
                tempResult = tempResult.multiply(BigInteger.valueOf(factor));
            }

            return tempResult;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
