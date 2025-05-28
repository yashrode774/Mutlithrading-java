package org.example;

class A implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hi " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class B implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Hello " + i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadWithRunnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new A());
        t1.start();

        Thread t2 = new Thread(new B());
        t2.start();
    }
}





