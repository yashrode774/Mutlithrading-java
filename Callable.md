## Callable example. 

```java
package org.example;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        // Callable returns a result and may throw an exception
        Callable<Integer> task = () -> {
            Thread.sleep(2000); // Simulate long-running task
            return 24;
        };

        Future<Integer> future = executor.submit(task);

        try {
            // Wait and get the result from Callable
            Integer result = future.get(); // can also use future.get(3, TimeUnit.SECONDS)
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error occurred: " + e.getMessage());
        } finally {
            executor.shutdown(); // Always shut down executor
        }
    }
}
```
