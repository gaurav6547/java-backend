import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ContentParserTask implements Runnable{
    private final int taskId;

    ContentParserTask(int taskId){
        this.taskId = taskId;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + "task running..." + taskId);
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class FixedThreadPoolExample{

    public static void main(String[] args){
    ExecutorService executor = Executors.newFixedThreadPool(3);

    for(int i = 1; i <= 10; i++){
        System.out.println("-----------------------");
        executor.execute(new ContentParserTask(i));
    }

    executor.shutdown();
    }
}