import java.util.stream.IntStream;

public class ParallelStreamPerformance {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        // Sequential Stream
        IntStream.range(1, 10_000_000).sum();

        long end = System.currentTimeMillis();
        System.out.println("Sequential Stream Time: " + (end - start) + " ms");

        start = System.currentTimeMillis();

        // Parallel Stream
        IntStream.range(1, 10_000_000).parallel().sum();

        end = System.currentTimeMillis();
        System.out.println("Parallel Stream Time: " + (end - start) + " ms");
    }
}

