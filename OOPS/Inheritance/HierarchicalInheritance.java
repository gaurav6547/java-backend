//3. Hierarchical Inheritance - Employee Roles (Same Parent, Different Behaviors)
//✅ Why Hierarchical Inheritance?
//
//Different types of employees have a common base but different responsibilities.
//A Manager, Developer, and HR share Employee properties but have unique behaviors.

// Parent class
class Employee {
    protected String name;
    
    public Employee(String name) {
        this.name = name;
    }
    
    public void work() {
        System.out.println(name + " is working...");
    }
}

// Child class 1
class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }
    
    public void manageProjects() {
        System.out.println(name + " is managing projects.");
    }
}

// Child class 2
class Developer extends Employee {
    public Developer(String name) {
        super(name);
    }
    
    public void writeCode() {
        System.out.println(name + " is writing code.");
    }
}

// Child class 3
class HR extends Employee {
    public HR(String name) {
        super(name);
    }
    
    public void recruit() {
        System.out.println(name + " is recruiting employees.");
    }
}

public class Main {
    public static void main(String[] args) {
        Manager m = new Manager("Alice");
        Developer d = new Developer("Bob");
        HR h = new HR("Charlie");

        m.manageProjects();
        d.writeCode();
        h.recruit();
    }
}
