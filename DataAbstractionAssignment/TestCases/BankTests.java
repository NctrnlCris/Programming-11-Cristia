import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import static junit.framework.TestCase.assertEquals;


public class BankTests {
    Withdraw SaveWithdrawal;
    Deposit CheckDeposit;
    Customer BOB = new Customer();



    @Before
    public void setup(){
        //Some starting variables to be used in toString tests
        CheckDeposit = new Deposit(400.00, new Date(), Customer.CHECKING);
        SaveWithdrawal = new Withdraw(100.00, new Date(), Customer.SAVINGS);



    }
    @Test
    public void Deposittostring(){
        // Testing Deposits are properly converted to strings
        assertEquals(CheckDeposit.toString(), "Deposit of: $" + 400.00 + " Date: " + new Date() +" into account: "+ Customer.CHECKING);
    }
    @Test
    public void WithdrawaltoString(){
        // Testing Withdrawals are properly converted to strings
        assertEquals(SaveWithdrawal.toString(),"Withdrawal of: $" + 100.00 + " Date: " + new Date() +" from account: "+ Customer.SAVINGS);
    }

    @Test
    public void Deposittest(){
        // Checking starting balance is 0
        assertEquals(BOB.getcheckBalance(),0.0);
        assertEquals(BOB.getsavingBalance(),0.0);
        // Checking a negative cannot be deposited
        BOB.deposit(-500.0, new Date(), "SAVINGS");
        assertEquals(BOB.getsavingBalance(), 0.0);
        // Deposit into checking account and checking amount
        BOB.deposit(200.00, new Date(),"CHECKING");
        assertEquals(BOB.getcheckBalance(),200.00);
        // Checking that checking account deposits are added and savings account remains unaffected
        BOB.deposit(200.00, new Date(),"CHECKING");
        assertEquals(BOB.getcheckBalance(),400.00);
        assertEquals(BOB.getsavingBalance(),0.0);
        // Deposit into savings account and checking amount and checking account remains unaffected
        BOB.deposit(120.00, new Date(), "SAVINGS");
        assertEquals(BOB.getsavingBalance(),120.00);
        assertEquals(BOB.getcheckBalance(),400.00);
    }

    @Test
    public void Withdrawaltest(){
        // Depositing a starting amount
        BOB.deposit(200.00, new Date(),"CHECKING");
        assertEquals(BOB.getcheckBalance(),200.00);
        // Checking a negative cannot be withdrawn
        BOB.withdraw(-20.00, new Date(), "CHECKING");
        assertEquals(BOB.getcheckBalance(), 200.00);
        // Withdrawal from checking and verifying balance
        BOB.withdraw(60.00, new Date(),"CHECKING");
        assertEquals(BOB.getcheckBalance(),140.00);
        // Withdrawal from checking and verifying both withdrawals are added
        BOB.withdraw(200.00, new Date(), "CHECKING");
        assertEquals(BOB.getcheckBalance(),-60.00);
        // Depositing a starting amount
        BOB.deposit(120.00, new Date(), "SAVINGS");
        assertEquals(BOB.getsavingBalance(),120.00);
        // Withdrawal from savings and verifying balance
        BOB.withdraw(119.00, new Date(), "SAVINGS");
        assertEquals(BOB.getsavingBalance(), 1.00);
    }




}
