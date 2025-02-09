import java.util.LinkedList;

public class TaskSchedular{
    public static void main(String[] args){

        LinkedList<String> tasks = new LinkedList<>();

        tasks.add("task1");
        tasks.add("task2");
        tasks.add("task3");
        //total time of add n task is O(n)
        System.out.println("Initial task list is : " + tasks);

        while(!tasks.isEmpty()){
            String task = tasks.poll(); //remove the head of the queue   O(n)
            System.out.println("processing task : " + task);
        }
    }
}