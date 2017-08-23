package grupoc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import model.Transaction;
import model.TypeTransaction;

public class TransactionTest {

	@Test
	public void testIfBuildANewTransactionAndIsCreditThenTheValueIsPositive() {
		Transaction transaction = new Transaction(TypeTransaction.CREDIT, new Double(5.0));
		Assert.assertEquals(transaction.getValueForSum(), new Double(5.0) );
	}
	@Test
	public void testIfBuildANewTransactionAndIsDebitThenTheValueIsNegative() {
		Transaction transaction = new Transaction(TypeTransaction.DEBIT, new Double(5.0));
		Assert.assertEquals(transaction.getValueForSum(), new Double(-5.0) );
	}
}
