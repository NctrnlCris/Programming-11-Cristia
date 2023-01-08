import java.util.ArrayList;
import java.util.Date; // Date class so we can get a unique date using "new Date()"

public class Customer {
    private final int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<>();
    private ArrayList<Withdraw> withdraws = new ArrayList<>();
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVINGS = "Savings";

    Customer(){
        accountNumber= 0;
        name = "Bot";
        savingRate = 0;
    }
    Customer(String name, int accountNumber, double checkBalance, double savingBalance){
        // Default constructor
        this.name = name;
        this.accountNumber = accountNumber;
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();
        this.checkBalance = checkBalance;
        this.savingBalance = savingBalance;



    }


    public void deposit(double amt, Date date, String account) {
        /* Requires: amt, date, account type
           Modifies: the amt of money in account
           Effects: Adds a deposit to account and balance increases
         */
        if (amt > 0) {
            if (account.equals("CHECKING")) {
                checkBalance += amt;
            } else if (account.equals("SAVINGS")) {
                savingBalance += amt;
            }
            deposits.add(new Deposit(amt, date, account));
        }
    }
    public void withdraw(double amt, Date date, String account){
        /* Requires: amt, date, account type
           Modifies: the amt of money in account
           Effects: Subtracts a withdrawal from account and balance decreases. Runs overdraft method
         */
        if (amt>0){
            if (account.equals("CHECKING")){
                checkBalance -= amt;
            }
            else if (account.equals("SAVINGS")){
                savingBalance -= amt;
            }
        }
        withdraws.add(new Withdraw(amt, date, account));
        checkOverdraft();

    }
    private void checkOverdraft(){
        // Effects: Check to see if account balance is negative and notifies customer
        if (checkBalance < 0) {
            double owed = 0 - checkBalance;
            System.out.println("Your checking account has overdrafted by $" + owed + " Pay up!");
        } else if (savingBalance < 0) {
            double owed = 0 - savingBalance;
                System.out.println("Your savings account has overdrafted by $" + owed + " Pay up!");
        }
        //Method is automatically run during withdrawals
    }






    //do not modify
    public void displayDeposits(){
        // Effects: Displays all deposits in the ArrayList
        for(Deposit d : deposits){
            System.out.println(d);

        }
    }
    //do not modify
    public void displayWithdraws(){
        // Effects: Displays all withdrawals in the ArrayList
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    public double getcheckBalance() {
        return checkBalance;
    }

    public double getsavingBalance() {
        return savingBalance;
    }
    public void printBalance(){
        // Effects: Prints out balance of all accounts
            System.out.println("\n" + "Current Balance in " + "SAVINGS" + " is: $" + savingBalance);
            System.out.println("Current Balance in " + "CHECKING" + " is: $" + checkBalance + "\n\n");

        }
    }


