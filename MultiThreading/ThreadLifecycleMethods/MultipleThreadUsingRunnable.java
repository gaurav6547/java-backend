

class MyRunnable implements Runnable{

    private String taskName;

    MyRunnable(String taskName){
        this.taskName = taskName;
    }

    public void run(){
        for(int i = 0; i <= 5; i++){

        System.out.println(taskName + " - Count: " + i);
        try {
            Thread.sleep(1000);  // Sleep for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }

}

public class MultipleThreadUsingRunnable{
    public static void main(String[] args){

        Thread t1 = new Thread(new MyRunnable("Thread-1"));
        Thread t2 = new Thread(new MyRunnable("Thread-2"));
        Thread t3 = new Thread(new MyRunnable("Thread-3"));

        t1.start();
        t2.start();
        t3.start();
    }
}