import java.util.Date;

public class Bank {
    public static void main(String[] args) {
        // Running our main class with various withdrawals and deposits
        Customer Jimmy = new Customer();
        Jimmy.deposit(400.0, new Date(),"CHECKING");
        Jimmy.displayDeposits();
        Jimmy.printBalance();
        Jimmy.deposit(500.0, new Date(), "SAVINGS");
        Jimmy.displayDeposits();
        Jimmy.printBalance();
        Jimmy.withdraw(320.0, new Date(), "CHECKING");
        Jimmy.displayWithdraws();
        Jimmy.printBalance();
        Jimmy.withdraw(720.0, new Date(), "SAVINGS");
        Jimmy.displayWithdraws();
        Jimmy.printBalance();
    }
}
