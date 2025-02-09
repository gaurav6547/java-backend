//2. Multilevel Inheritance - Vehicle Hierarchy (General → Specific → More Specific)
//✅ Why Multilevel Inheritance?
//
//A Car is a Vehicle, and an ElectricCar is a more advanced Car.
//It follows a natural progression of specialization.
//Each level adds new behaviors, making it ideal for gradual specialization.
// Base class
class Vehicle {
    public void start() {
        System.out.println("Vehicle is starting...");
    }
}

// Derived class
class Car extends Vehicle {
    public void drive() {
        System.out.println("Car is driving...");
    }
}

// Another derived class
class ElectricCar extends Car {
    public void chargeBattery() {
        System.out.println("Electric car battery is charging...");
    }
}

public class MultilevelInheritance {
    public static void main(String[] args) {
        ElectricCar tesla = new ElectricCar();
        tesla.start(); // Inherited from Vehicle
        tesla.drive(); // Inherited from Car
        tesla.chargeBattery(); // Specific to ElectricCar
    }
}
