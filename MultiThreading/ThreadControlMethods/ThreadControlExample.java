class ControlThread implements Runnable {
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " started.");

            // Demonstrate sleep(long millis)
            System.out.println(Thread.currentThread().getName() + " sleeping for 2 seconds...");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " woke up.");

            // Demonstrate sleep(long millis, int nanos)
            System.out.println(Thread.currentThread().getName() + " sleeping for 1 second and 500 nanoseconds...");
            Thread.sleep(1000, 500);
            System.out.println(Thread.currentThread().getName() + " woke up after nanos sleep.");

            // Demonstrate yield()
            System.out.println(Thread.currentThread().getName() + " yielding execution...");
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + " resumed after yielding.");

            // Demonstrate interrupt()
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
                return;
            }
            
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " processing: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted during sleep.");
        }
    }
}

public class ThreadControlExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ControlThread(), "Worker-1");
        Thread t2 = new Thread(new ControlThread(), "Worker-2");

        // Demonstrate setDaemon()
        t2.setDaemon(true);
        System.out.println("Is " + t2.getName() + " a daemon thread? " + t2.isDaemon());

        t1.start();
        t2.start();

        // Allow threads to run for 3 seconds before interrupting
        Thread.sleep(3000);
        t1.interrupt();  // Interrupt Worker-1

        t1.join();  // Wait for t1 to finish before continuing
        System.out.println("Main thread exiting.");
    }
}
