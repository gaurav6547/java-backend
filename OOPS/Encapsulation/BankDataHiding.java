

class BankAccount{

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    BankAccount(String accountNumber, String accountHolderName, double initialBalance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        //this.balance = initialBalance;
        if(initialBalance >= 0){
            this.balance = initialBalance;
        }
        else{
            System.out.println("Initial balance cannot be negative. Setting to 0.");
            this.balance = 0;
        }
    }

    //public getter methods to access the data
    public String getAccountNumber(){
        return accountNumber;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

    public double getBalance(){
        return balance;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void addMoney(double amount){
        if(amount >= 0){
            System.out.println("Initial balance is" + balance);
            balance += amount;
            System.out.println("Initial balance is" + balance);
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdrawMoney(double amount){
        if(amount > balance){
            System.out.println("unsufficient balance.... available balance is = " + balance);
        }
        else{
            balance -= amount;
            System.out.println("withdrwal successfully = " + amount);
            System.out.println("available balance is" + balance);
        }
    }
}

public class BankDataHiding{
    public static void main(String[] args){
        BankAccount account = new BankAccount("41809473205311350","Gaurav Murumkar", 50000);
        account.addMoney(12345);
        account.withdrawMoney(12312);
    }
}