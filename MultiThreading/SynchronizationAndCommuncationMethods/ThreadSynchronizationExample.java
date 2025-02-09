import java.util.LinkedList;
import java.util.Queue;

class SharedResource {
    private Queue<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 5; // Maximum items in the queue

    // Producer method to add items to the queue
    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == CAPACITY) {
            System.out.println("Queue is full. Producer is waiting...");
            wait();  // Wait until space becomes available
        }
        queue.add(item);
        System.out.println("Produced: " + item);
        notify();  // Notify consumer that an item is available
    }

    // Consumer method to remove items from the queue
    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Queue is empty. Consumer is waiting...");
            wait();  // Wait until an item is produced
        }
        int item = queue.poll();
        System.out.println("Consumed: " + item);
        notify();  // Notify producer that space is available
        return item;
    }
}

// Producer thread
class Producer implements Runnable {
    private SharedResource resource;

    Producer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                resource.produce(i);
                Thread.sleep(500);  // Simulate processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Consumer thread
class Consumer implements Runnable {
    private SharedResource resource;

    Consumer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                resource.consume();
                Thread.sleep(1000);  // Simulate processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadSynchronizationExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producerThread = new Thread(new Producer(resource), "ProducerThread");
        Thread consumerThread = new Thread(new Consumer(resource), "ConsumerThread");

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed.");
    }
}
