

class MyThread extends Thread{

    private String Taskname;

    MyThread(String Taskname){
        this.Taskname = Taskname;
    }

    public void run(){
        for(int i = 1; i <= 5; i++){
            System.out.println(Taskname + " - Count" + i);
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class MultipleThread{
    public static void main(String[] args){

        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");

        t1.start();
        t2.start();

    }
}