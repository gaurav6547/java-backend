import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
import static java.util.stream.Collectors.*;

class Order {
    private String customerId;
    private String status; // e.g., "COMPLETED", "CANCELED", "PENDING"
    private double amount;

    public Order(String customerId, String status, double amount) {
        this.customerId = customerId;
        this.status = status;
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }
}

public class Program1 {

    public static void main(String[] args) {
        // Step 1: Generate a large dataset of orders
        List<Order> orders = generateOrders(1_000_000); // 1 million orders

        for(Order item : orders){
            System.out.println("Items : " + item);
        }


        // Step 2: Filter out canceled orders and calculate total completed orders value
        double totalCompletedOrdersValue = orders.parallelStream()
                .filter(order -> "COMPLETED".equals(order.getStatus()))
                .mapToDouble(Order::getAmount)
                .sum();

        System.out.println("Total value of completed orders: $" + totalCompletedOrdersValue);

        // Step 3: Find the top 10 customers by total spending
        Map<String, Double> topCustomers = orders.parallelStream()
                .filter(order -> "COMPLETED".equals(order.getStatus()))
                .collect(groupingBy(Order::getCustomerId, summingDouble(Order::getAmount)))
                .entrySet()
                .parallelStream() // Parallel stream for sorting large map
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue())) // Sort descending by value
                .limit(10)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Top 10 Customers by Spending:");
        topCustomers.forEach((customerId, total) -> 
            System.out.println("Customer: " + customerId + ", Total Spending: $" + total));
    }

    // Helper method to generate random orders
    private static List<Order> generateOrders(int count) {
        Random random = new Random();
        return IntStream.range(0, count)
                .mapToObj(i -> new Order(
                        "Customer" + random.nextInt(1000), // 1000 unique customers
                        random.nextBoolean() ? "COMPLETED" : "CANCELED",
                        random.nextDouble() * 1000 // Order amount between 0 and 1000
                ))
                .collect(toList());
    }
}
