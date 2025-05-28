package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Task A implementing Runnable
class TaskA implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hi " + i);
            try {
                Thread.sleep(100); // Simulate some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Good practice
                System.out.println("TaskA was interrupted.");
            }
        }
    }
}

// Task B implementing Runnable
class TaskB implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("TaskB was interrupted.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit tasks to the executor
        executor.execute(new TaskA());
        executor.execute(new TaskB());

        // Shutdown the executor gracefully
        executor.shutdown();
    }
}


