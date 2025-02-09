import java.util.*;
import java.util.stream.Collectors;

class Transaction { //trnsaction class hash , id, amount, status.
    private int id;
    private double amount;
    private String status;

    public Transaction(int id, double amount, String status) { //constructor of transaction
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}


public class ParallelStreamExample{
    public static void main(String[] args){

        List<Transaction> transactions = generateTransactions(1_000_000);//this is only calling the functions not an collections
        //System.out.println("---------------- \n" + transactions);// get the list of generated transactions

        double threshold = 10_000.0;// set the threshold value

        long startTime = System.currentTimeMillis();

        //now we have the list of transactions in the transactions
        List<Transaction> processedTransactions = transactions.parallelStream()

        .filter(transaction -> transaction.getAmount() > threshold)//compare with transaction amount

        .peek(transaction -> transaction.setAmount(transaction.getAmount() * 1.1))

        .collect(Collectors.toList());

        long endTime = System.currentTimeMillis();

        System.out.println("Number of transactions processed: " + processedTransactions.size());
        System.out.println("Time taken: " + (endTime - startTime) + " ms");

        // Optional: Display a few results
        processedTransactions.stream().limit(25).forEach(System.out::println);
    }

    private static List<Transaction> generateTransactions(int count) //methods is belon to the class rather than object of the class
    {
        Random random = new Random(); //used to generate random numbers
        List<Transaction> transactions = new ArrayList<>(); //new arrayList is create to hold th transaction object
        for (int i = 1; i <= count; i++) { 
            transactions.add(new Transaction(
                    i,
                    random.nextDouble() * 20_000,  // Random amount between 0 and 20,000
                    "PENDING"
            ));
        }
        return transactions;//return the list of transactions
    }
}