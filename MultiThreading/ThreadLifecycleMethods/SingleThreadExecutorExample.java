import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DatabaseWriterTask implements Runnable {
    private final String record;

    public DatabaseWriterTask(String record) {
        this.record = record;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " saving record: " + record);
        try {
            Thread.sleep(1000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Record " + record + " saved.");
    }
}

public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 5; i++) {
            executor.execute(new DatabaseWriterTask("User-" + i));
        }

        executor.shutdown();
    }
}
