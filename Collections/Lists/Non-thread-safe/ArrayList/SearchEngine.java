import java.util.ArrayList;

public class SearchEngine{
    public static void main(Strin   g[] args){
        ArrayList<String> lists = new ArrayList<>();

        lists.add("Result 1 : Java Collections");
        lists.add("Result 2 : Java Multithreading");
        lists.add("Result 3 : Java Parallel stream");

        System.out.println("Results are : " + lists);

        for(int i = 0; i < lists.size(); i++){
            System.out.println((i + 1) + ". searching : " + lists.get(i));
        }
    }
}