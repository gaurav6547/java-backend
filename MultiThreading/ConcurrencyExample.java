import java.util.concurrent.*;

public class ConcurrencyExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submitting Callable tasks
        Callable<String> task1 = () -> {
            Thread.sleep(2000);
            return "Task 1 completed";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "Task 2 completed";
        };

        Callable<String> task3 = () -> "Task 3 completed";

        // Execute tasks
        Future<String> result1 = executor.submit(task1);
        Future<String> result2 = executor.submit(task2);
        Future<String> result3 = executor.submit(task3);

        // Wait for results
        System.out.println(result1.get());
        System.out.println(result2.get());
        System.out.println(result3.get());

        executor.shutdown();
    }
}

