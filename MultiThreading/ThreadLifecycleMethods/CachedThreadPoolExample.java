import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WebScraperTask implements Runnable{

    private String url;

    WebScraperTask(String url){
        this.url = url;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " fetching data from " + url);
        try {
            Thread.sleep(2000);  // Simulate network call
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Data fetched from " + url);
    }

}

public class CachedThreadPoolExample{

    public static void main(String[] main){
        ExecutorService runner = Executors.newCachedThreadPool();

        for(int i = 1; i <= 200; i++){
            runner.execute(new WebScraperTask("https://example.com/page-" + i));
        }

        runner.shutdown();
    }
}