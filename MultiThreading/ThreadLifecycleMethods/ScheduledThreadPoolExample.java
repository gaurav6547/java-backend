import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.Date;

class ReportGeneratorTask implements Runnable {
    @Override
    public void run() {
        long currentTimeMillis = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String formattedDate = sdf.format(new Date(currentTimeMillis));

        System.out.println("Formatted Date: " + formattedDate);
        System.out.println(Thread.currentThread().getName() + " generating report at " + formattedDate);
    }
}

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        // Schedule a task to run every 5 seconds with an initial delay of 2 seconds
        executor.scheduleAtFixedRate(new ReportGeneratorTask(), 2, 5, TimeUnit.SECONDS);

        // Schedule another task with a fixed delay of 3 seconds after task completion
        executor.scheduleWithFixedDelay(new ReportGeneratorTask(), 2, 3, TimeUnit.SECONDS);

        // Let the tasks run for 20 seconds before shutting down
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
