//1. Abstract Class with Abstract Method (Payment processing system)

abstract class PaymentProcessor{

    abstract void processPayment(double amount);

    void logTransaction(double amount){
        System.out.println("Transaction of ${} recorded."+ amount);
    }
}

class CreaditCardPayment extends PaymentProcessor{

    @Override
    public void processPayment(double amount){
        System.out.println("making credit card payment...");
        logTransaction(amount);
    }
}

class DebitCardPayment extends PaymentProcessor{
    
    @Override
    public void processPayment(double amount){
        System.out.println("making debit card payment...");
        logTransaction(amount);
    }
}



public class PaymentApp{

    public static void main(String args[]){
        PaymentProcessor credit = new CreaditCardPayment();
        credit.processPayment(3129.04);

        PaymentProcessor debit = new DebitCardPayment();
        debit.processPayment(431341.90);

    }
}