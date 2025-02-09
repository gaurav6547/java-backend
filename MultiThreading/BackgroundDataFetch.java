
public class BackgroundDataFetch implements Runnable{

    @Override
    public void run(){
        System.out.println("Fetching data in the background...");
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            System.out.println("Data fetch interrupted");
        }
        System.out.println("Data fetched successfully!");
    }

    public static void main(String[] args){
        Thread thread = new Thread(new BackgroundDataFetch());

        thread.start();
        System.out.println("Main thread is free to do other tasks...");
    }
}