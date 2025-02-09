import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable{

    private String taskName;

    WorkerThread(String taskName){
        this.taskName = taskName;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " executing " + taskName);
        try {
            System.out.println("-----");
            Thread.sleep(0000);  // Simulate task execution
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(taskName + " completed.");
    }
}

public class MultipleThreadUsingExecutorService{
    public static void main(String[] args){

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(int i = 0; i <= 5; i++){
            executor.execute(new WorkerThread("Task - " + i));
        }
        executor.shutdown();
    }
}