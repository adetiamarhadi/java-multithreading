package com.github.adet.section2;

public class ExtendThread {

    public static void main(String[] args) {

        Thread thread = new NewThread();
        thread.setName("New Worker Thread");
        thread.start();
    }

    private static class NewThread extends Thread {

        @Override
        public void run() {
            System.out.println("Hello from " + this.getName());
        }
    }
}
