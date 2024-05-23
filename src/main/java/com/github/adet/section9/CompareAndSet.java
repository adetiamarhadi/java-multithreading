package com.github.adet.section9;

import java.util.concurrent.atomic.AtomicReference;

public class CompareAndSet {

    public static void main(String[] args) {

        String oldName = "old name";
        String newName = "new name";

        AtomicReference<String> atomicReference = new AtomicReference<>(oldName);

        if (atomicReference.compareAndSet(oldName, newName)) {
            System.out.println("new value: " + atomicReference.get());
        } else {
            System.out.println("there is no update value");
        }

        if (atomicReference.compareAndSet(oldName, newName)) {
            System.out.println("new value: " + atomicReference.get());
        } else {
            System.out.println("there is no update value");
        }
    }
}
