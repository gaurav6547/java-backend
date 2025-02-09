import java.util.ArrayList;

public class PreventDataCorruption{

    private static final ArrayList<Integer> list = new ArrayList<>();
    private static int counter = 0;

    public static void main(String[] args){

        Runnable addTask = () -> {
            for(int i = 0; i < 1000; i++){
                synchronized (list){
                    list.add(i);
                }
            }
        };

        Runnable incrementTask = () -> {
            for(int i = 0; i < 1000; i++){
                synchronized (PreventDataCorruption.class){
                    counter++;
                }
            }
        };

        Thread t1 = new Thread(addTask);
        Thread t2 = new Thread(addTask);
        Thread t3 = new Thread(incrementTask);
        Thread t4 = new Thread(incrementTask);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }
        catch (InterruptedException e){
             e.printStackTrace();
        }

        System.out.println("Final List Size: " + list.size()); // Should be 2000
        System.out.println("Final Counter Value: " + counter); // Should be 2000

    }
}