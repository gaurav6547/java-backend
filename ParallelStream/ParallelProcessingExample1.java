import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ParallelProcessingExample1 {
    // RecursiveTask for summing an array
    static class SumTask extends RecursiveTask<Long> {
        private final int[] numbers;
        private final int start;
        private final int end;
        private static final int THRESHOLD = 10; // Smallest chunk size to compute directly

        // Constructor
        public SumTask(int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            // Log the task being processed
            System.out.println("Computing range: " + start + " to " + end + " on thread " 
                    + Thread.currentThread().getName());

            // If the range is small enough, compute directly
            if ((end - start) <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += numbers[i];
                }
                System.out.println("Computed sum for range: " + start + " to " + end 
                        + " = " + sum + " on thread " + Thread.currentThread().getName());
                return sum;
            } else {
                // Split the task into two subtasks
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(numbers, start, mid);
                SumTask rightTask = new SumTask(numbers, mid, end);

                // Fork the left task (execute asynchronously)
                leftTask.fork();

                // Compute the right task directly
                long rightResult = rightTask.compute();

                // Wait for the left task to finish and combine results
                long leftResult = leftTask.join();

                System.out.println("Combined result for range: " + start + " to " + end 
                        + " = " + (leftResult + rightResult) + " on thread " 
                        + Thread.currentThread().getName());
                return leftResult + rightResult;
            }
        }
    }

    public static void main(String[] args) {
        // Initialize an array with numbers from 1 to 100
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        // Measure parallel processing time
        long parallelStartTime = System.nanoTime();

        // Use ForkJoinPool for parallel processing
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(numbers, 0, numbers.length);

        long parallelSum = pool.invoke(task);
        long parallelEndTime = System.nanoTime();

        System.out.println("Parallel Sum: " + parallelSum + 
                " computed in " + (parallelEndTime - parallelStartTime) + " ns");

        // Sequential processing for comparison
        long sequentialStartTime = System.nanoTime();

        long sequentialSum = 0;
        for (int num : numbers) {
            sequentialSum += num;
        }

        long sequentialEndTime = System.nanoTime();

        System.out.println("Sequential Sum: " + sequentialSum + 
                " computed in " + (sequentialEndTime - sequentialStartTime) + " ns");
    }
}

