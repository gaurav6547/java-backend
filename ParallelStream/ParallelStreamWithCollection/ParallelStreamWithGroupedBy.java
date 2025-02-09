import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParallelStreamWithGroupedBy {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Map<String, List<Integer>> grouped = numbers.parallelStream()
                                                    .collect(Collectors.groupingBy(num -> num % 2 == 0 ? "Even" : "Odd"));

        Map<String, Long> groupedCount = numbers.stream()
                                                    .collect(Collectors.groupingBy(num -> num % 2 == 0 ? "Even" : "Odd", Collectors.counting()));

        System.out.println(grouped);
        System.out.println(groupedCount);
    }
}

