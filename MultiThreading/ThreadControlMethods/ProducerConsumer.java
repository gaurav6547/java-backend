import java.util.LinkedList;

class SharedBuffer{

    private LinkedList<Integer> buffer = new LinkedList<>();
    private final int capacity = 5;

    public synchronized void produce(int value) throws InterruptedException{
        if(buffer.size() == capacity){
            System.out.println("Buffer size is full, producer is waiting...");
            wait();
        }
        buffer.add(value);
        System.out.println("Produced - " + value);
        notify();
    }

    public synchronized int consume() throws InterruptedException{
        while(buffer.isEmpty()){
            System.out.println("Consumer is waiting...");
            wait();
        }
        int value = buffer.removeFirst();
        System.out.println("Comsume - " + value);
        notify();//notify with return value
        return value;
    }
}

class Producer extends Thread{
    private SharedBuffer buffer;

    Producer(SharedBuffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        int value = 1;
        try{
            while(true){
                buffer.produce(value++);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread{
    
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        
        try{
            while(true){
                buffer.consume();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumer{
    public static void main(String[] args){
        SharedBuffer buffer = new SharedBuffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}