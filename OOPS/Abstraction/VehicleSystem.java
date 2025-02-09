//2. Abstract Class with Concrete Method (Vehicle Control System)

abstract class Vehicle{
    abstract void start();

    void stop(){
        System.out.println("stop...");
    }
}


class Car extends Vehicle{

    @Override
    public void start(){
        System.out.println("car engine is started");
    }
}

class Bike extends Vehicle {
    
    @Override
    void start() {
        System.out.println("Bike engine started with a self-start button.");
    }
}


public class VehicleSystem{
    public static void main(String[] args){
        Vehicle car = new Car();
        car.start();
        car.stop();

        Vehicle bike = new Bike();
        bike.start();
        bike.stop();
    }
}