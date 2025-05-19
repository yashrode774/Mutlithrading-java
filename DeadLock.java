package org.example;

public class Test {

    // Shared String objects used for synchronization
    static String s1 = "yash";
    static String s2 = "rode";

    public static void main(String[] args) throws Exception {

        // Thread t1 tries to lock s1 first, then s2
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    synchronized(s1) { // Acquires lock on s1
                        try {
                            System.out.println(Thread.currentThread().getName() + " locked " + s1);
                            Thread.sleep(3000); // Simulate some work while holding lock on s1
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        synchronized (s2) { // Tries to acquire lock on s2
                            System.out.println(Thread.currentThread().getName() + " locked " + s2);
                            System.out.println(s2 + s2); // Print s2 twice
                        }
                    }
                }
            }
        };

        // Thread t2 tries to lock s2 first, then s1
        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    synchronized(s2) { // Acquires lock on s2
                        System.out.println(Thread.currentThread().getName() + " locked " + s2);
                        synchronized (s1) { // Tries to acquire lock on s1
                            System.out.println(Thread.currentThread().getName() + " locked " + s1);
                            System.out.println(s2 + s1); // Print s2 followed by s1
                        }
                    }
                }
            }
        };

        // Start both threads
        t1.start();
        t2.start();
    }
}
