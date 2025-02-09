class MyRunnable implements Runnable{

    @Override
    public void run(){
        System.out.println("Thread is running...");
    }
}

public class ThreadWithRunnable{
    public static void main(String[] main){

        Thread t1 = new Thread(new MyRunnable());

        t1.start();
    }
}