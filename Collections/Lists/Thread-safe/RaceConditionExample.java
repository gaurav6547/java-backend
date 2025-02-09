

public class RaceConditionExample{

    private static int counter = 0;

    public static void main(String args[]){

        Runnable performTask = () -> {
            for(int i = 0; i < 20000; i++){
                counter++;
            }
        };

        Thread t1 = new Thread(performTask);
        Thread t2 = new Thread(performTask);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + counter);

    }
}