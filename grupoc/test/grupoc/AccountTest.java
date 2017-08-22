package grupoc;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import model.Account;
import model.Transaction;

public class AccountTest {


	@Test
	public void testIfAddNewTransactionToAccountThenTheAccountHasAElementPlus() {
	
		Account account = new Account();
		Transaction transaction = Mockito.mock(Transaction.class);
		account.addTransaction(transaction);
		Assert.assertEquals(account.countTransaction(),new Integer(1));
		
	}

}
