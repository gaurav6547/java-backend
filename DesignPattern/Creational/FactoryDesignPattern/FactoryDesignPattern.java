// Product Interface
interface PaymentProcessor { void processPayment(); }

// Concrete Products
class PayPalProcessor implements PaymentProcessor {
    public void processPayment() { System.out.println("Processing PayPal payment"); }
}

class CreditCardProcessor implements PaymentProcessor {
    public void processPayment() { System.out.println("Processing Credit Card payment"); }
}

// Factory Method
class PaymentFactory {
    public static PaymentProcessor getPaymentProcessor(String type) {
        return switch (type) {
            case "PayPal" -> new PayPalProcessor();
            case "CreditCard" -> new CreditCardProcessor();
            default -> throw new IllegalArgumentException("Invalid payment type");
        };
    }
}

// Client
public class FactoryDesignPattern {
    public static void main(String[] args) {
        PaymentProcessor payment = PaymentFactory.getPaymentProcessor("PayPal");
        payment.processPayment();
    }
}

