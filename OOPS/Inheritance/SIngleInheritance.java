//1. Single Inheritance - Bank System (General → Specific)
//✅ Why Single Inheritance?
//
//A SavingsAccount is a specialized version of a BankAccount.
//There is a clear parent-child relationship (General → Specific).
//No need for multiple parents or hierarchical expansion.

class BankAccount{
    protected double balance;

    BankAccount(double balance){
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount{

    private double interestRate;

    SavingsAccount(double balance, double interestRate){
        super(balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        balance += balance * interestRate / 100;
    }
}

public class SIngleInheritance{
    public static void main(String[] args){

        SavingsAccount sa = new SavingsAccount(1000, 5);
        sa.addInterest();
        System.out.println("New Balance: " + sa.getBalance());

    }
}