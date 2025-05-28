package org.example;

class A extends Thread {
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

class B extends Thread {
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

public class Thread {
    public static void main(String[] args) {
        A a = new A();
        a.start();

        B b = new B();
        b.start();
    }
}





