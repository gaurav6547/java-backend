

interface Coffee{
    String getDescription();
    double getCost();
}

class BasicCoffee implements Coffee{

    @Override
    public String getDescription(){
        return "Basic Coffee";
    }

    @Override
    public double getCost(){
        return 2.00;
    }
}

abstract class CoffeeDecorator implements Coffee{
    protected Coffee coffee;  //composition

    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public String getDescription(){
        return coffee.getDescription();
    }

    @Override
    public double getCost(){
        return coffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.50;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.25;
    }
}

public class DecoratorDesignPattern {
    public static void main(String[] args) {
        // Base coffee
        Coffee basicCoffee = new BasicCoffee();
        System.out.println(basicCoffee.getDescription() + " -> $" + basicCoffee.getCost());

        // Coffee with milk
        Coffee coffeeWithMilk = new MilkDecorator(basicCoffee);
        System.out.println(coffeeWithMilk.getDescription() + " -> $" + coffeeWithMilk.getCost());

        // Coffee with milk and sugar
        Coffee coffeeWithMilkAndSugar = new SugarDecorator(coffeeWithMilk);
        System.out.println(coffeeWithMilkAndSugar.getDescription() + " -> $" + coffeeWithMilkAndSugar.getCost());

        // Coffee with sugar only
        Coffee coffeeWithSugar = new SugarDecorator(basicCoffee);
        System.out.println(coffeeWithSugar.getDescription() + " -> $" + coffeeWithSugar.getCost());
    }
}