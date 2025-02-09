
class MyThread extends Thread{

    public void run(){

        try {
            // Display thread information
            System.out.println("-----------------------");
            System.out.println("* Thread Information - ");
            System.out.println("-----------------------");
            System.out.println("Thread ID: " + getId());
            System.out.println("Thread Name: " + getName());
            System.out.println("Thread Priority: " + getPriority());
            System.out.println("Thread State: " + getState());
            System.out.println("Active Thread Count: " + Thread.activeCount());
            System.out.println("-----------------------");

            // Simulate some work
            Thread.sleep(2000);

            // After sleep, show updated state
            System.out.println("Thread State After Sleep: " + getState());

        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        }
    }

}

public class ThreadInfoExample{

    public static void main(String[] args){

        MyThread t1 = new MyThread();

        t1.setName("worker-thread-1");
        t1.setPriority(Thread.NORM_PRIORITY);

        t1.start();

        Thread current = Thread.currentThread();

        System.out.println("Main Thread Name: " + current.getName());
        System.out.println("Main Thread ID: " + current.getId());
        System.out.println("Main Thread Priority: " + current.getPriority());
        System.out.println("Main Thread State: " + current.getState());
        System.out.println("Total Active Threads: " + Thread.activeCount());

    }
}