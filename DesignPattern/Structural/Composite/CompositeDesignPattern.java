import java.util.ArrayList;
import java.util.List; 


interface Employee{
    void showDetails();
}

class Developer implements Employee{
    private String name;
    private String position;

    public Developer(String name, String position){
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println("Developer: " + name + ", Position: " + position);
    }   
}

class Designer implements Employee {
    private String name;
    private String position;

    public Designer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println("Designer: " + name + ", Position: " + position);
    }
}


class Manager implements Employee{
    private String name;
    private String position;
    private List<Employee> suboridinates = new ArrayList<>();

    public Manager(String name, String position){
        this.name = name;
        this.position = position;
    }

    public void addSuboridinate(Employee empolyee){
        suboridinates.add(empolyee);
    }

    public void removeSuboridinate(Employee empolyee){
        suboridinates.remove(empolyee);
    }

    @Override
    public void showDetails(){

        for(Employee suboridinate : suboridinates){
            suboridinate.showDetails();
        }
    }
}

public class CompositeDesignPattern{
    public static void main(String[] args){
        Employee emp1 = new Developer("Gaurav", "Associate Software Eggineer");
        Employee emp2 = new Developer("Anupam", "Senior Software Eggineer");

        Employee designer1 = new Designer("Aishwarya", "Product Designer");

        Manager manager1 = new Manager("Appa", "Associate");
        manager1.addSuboridinate(emp1);
        manager1.addSuboridinate(emp2);
        manager1.addSuboridinate(designer1);

        Manager generalManager = new Manager("Eve", "General Manager");
        generalManager.addSuboridinate(manager1);

        generalManager.showDetails();
    }
}