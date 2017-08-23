package grupoc;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.omg.CORBA.UserException;

import exception.BalanceInsufficient;
import model.Account;
import model.Transaction;
import model.TypeTransaction;

public class AccountTest {


	@Test
	public void testIfAddNewTransactionToAccountThenTheAccountHasAElementPlus() throws BalanceInsufficient {
	
		Account account = new Account();
		Transaction transaction = Mockito.mock(Transaction.class);
		account.addTransaction(transaction);
		Assert.assertEquals(account.countTransaction(),new Integer(1));
		
	}
	
	@Test
	public void testIfAddNewTransactionWhatAddMoneyToAccountThenTheAccountHasABalanceOf5() throws BalanceInsufficient {
	
		Account account = new Account();
		Transaction transaction = Mockito.mock(Transaction.class);
		Mockito.when(transaction.getValueForSum()).thenReturn(new Double(5.0));
		Mockito.when(transaction.getTypeTransaction()).thenReturn(TypeTransaction.CREDIT);
		account.addTransaction(transaction);
		Assert.assertEquals(account.balance(),new Double(5.0));
		
	}
	@Test(expected=BalanceInsufficient.class)
	public void testIfAddNewTransactionWhatDebitMoneyToAccountThenBalanceInsufficient() throws BalanceInsufficient {
	
		Account account = new Account();
		Transaction transaction = Mockito.mock(Transaction.class);
		Mockito.when(transaction.getValue()).thenReturn(new Double(5.0));
		Mockito.when(transaction.getValueForSum()).thenReturn(new Double(-5.0));
		Mockito.when(transaction.getTypeTransaction()).thenReturn(TypeTransaction.DEBIT);
		account.addTransaction(transaction);
	}
	
}
