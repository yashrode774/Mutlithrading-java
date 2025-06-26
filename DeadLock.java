// Deadlock is a situation where two or more threads are waiting for each other to release resources, and as a result, none of them can proceed — they remain blocked forever.

// Thread 1 locks lock1 and waits for lock2.
// Thread 2 locks lock2 and waits for lock1.
// Both threads are waiting on each other forever ⇒ Deadlock
    

public class DeadlockExample {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock1...");
                try { Thread.sleep(100); } catch (Exception ignored) {}

                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock2...");
                try { Thread.sleep(100); } catch (Exception ignored) {}

                synchronized (lock1) {
                    System.out.println("Thread 2: Acquired lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
