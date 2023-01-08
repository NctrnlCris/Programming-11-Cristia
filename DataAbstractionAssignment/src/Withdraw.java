import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        // Default constructor
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        // Effects: Allows variables to be returned as strings
        return ("Withdrawal of: $" + amount + " Date: " + date + " from account: " + account);
    }
}
