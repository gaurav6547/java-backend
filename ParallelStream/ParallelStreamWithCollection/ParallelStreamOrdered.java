import java.util.Arrays;
import java.util.List;

public class ParallelStreamOrdered {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Measure time for forEach
        long startTime = System.currentTimeMillis();
        System.out.println("Parallel Stream with forEach:");
        numbers.parallelStream().forEach(num -> {
            System.out.print(num + " ");
        });
        long endTime = System.currentTimeMillis();
        System.out.println("\nTime taken by forEach: " + (endTime - startTime) + " ms");

        // Measure time for forEachOrdered
        startTime = System.currentTimeMillis();
        System.out.println("\nParallel Stream with forEachOrdered:");
        numbers.parallelStream().forEachOrdered(num -> {
            System.out.print(num + " ");
        });
        endTime = System.currentTimeMillis();
        System.out.println("\nTime taken by forEachOrdered: " + (endTime - startTime) + " ms");
    }
}

