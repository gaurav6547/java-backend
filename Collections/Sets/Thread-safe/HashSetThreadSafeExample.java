import java.util.HashSet;

public class HashSetThreadSafeExample {
    public static void main(String[] args) {
        HashSet<Integer> sharedSet = new HashSet<>();

        Runnable addTask = () -> {
            synchronized (sharedSet) {
                for (int i = 1; i <= 200; i++) {
                    //synchronized (sharedSet){
                    sharedSet.add(i);
                    System.out.println(Thread.currentThread().getName() + " added: " + i);
                }
            }
        };

        Thread thread1 = new Thread(addTask, "Thread-1");
        Thread thread2 = new Thread(addTask, "Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final size of the HashSet: " + sharedSet.size());
    }
}

