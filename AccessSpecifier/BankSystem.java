
public class BankSystem{

    private static class BankAccount{
        private double balance;// security data
        String accountNumber; //default access
        protected String accountType; //for subclasses
        public String bankName = "Global Bank"; //public informations
    

    public BankAccount(String accountNumber, String accountType){
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0.0;
    }

    public void deposit(double amount){
        if (amount <= 0) {
                throw new IllegalArgumentException("Deposit amount must be positive.");
            }
            balance += amount;
            System.out.println("Deposited $" + amount + ". New balance: $" + balance);
    }

    protected double getBalance(){
        return balance;
    }
}

    private static class SavingAccount extends BankAccount{
        private double interestRate;

        public SavingAccount(String accountNumber, double interestRate){
            super(accountNumber, "Savings");
            this.interestRate = interestRate;
        }

        public void applyInterest(){
            double interestBalance = getBalance() * (interestRate/100);
            deposit(interestBalance);
            System.out.println("Applied $" + interestBalance + " as interest.");
        }
    }

    public static void main(String[] args){

        SavingAccount savingAccount = new SavingAccount("781294735281", 7.95);

        savingAccount.deposit(1000); //accessible public method.
        savingAccount.applyInterest(); //accessible public method.

        //direct access example
        System.out.println("Bank Name : " + savingAccount.bankName);
        System.out.println("Bank account number : " + savingAccount.accountNumber);

        // System.out.println("Balance: " + account.balance); // Compilation Error: balance is private
        // System.out.println(account.getBalance()); // Compilation Error: getBalance() is protected

    }
}
