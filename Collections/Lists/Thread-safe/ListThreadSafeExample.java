import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListThreadSafeExample {
    public static void main(String[] args) {
        List<Integer> sharedList = Collections.synchronizedList(new ArrayList<>());

        Runnable addTask = () -> {
            for (int i = 1; i <= 500; i++) {
                sharedList.add(i); // No need to synchronize here since synchronizedList is used
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

        System.out.println("Final size of the List: " + sharedList.size());
    }
}

