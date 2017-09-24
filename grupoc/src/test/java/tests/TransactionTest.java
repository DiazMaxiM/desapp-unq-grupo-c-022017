package tests;


import org.junit.Test;

import junit.framework.Assert;
import model.Transaction;
import model.TypeStatusTransaction;
import model.TypeTransaction;

public class TransactionTest {

	@Test
	public void testIfBuildANewTransactionAndIsCreditThenTheValueIsPositive() {
		Transaction transaction = new Transaction(TypeTransaction.CREDIT, new Double(5.0));
		Assert.assertEquals(transaction.getValueForSum(), new Double(5.0));
		Assert.assertEquals(transaction.getTypeTransaction(), TypeTransaction.CREDIT);
		Assert.assertEquals(transaction.getTypeStatusTransaction(), TypeStatusTransaction.PENDING);
		Assert.assertTrue(transaction.isNotRejected());

	}

	@Test
	public void testIfBuildANewTransactionAndIsDebitThenTheValueIsNegative() {
		Transaction transaction = new Transaction(TypeTransaction.DEBIT, new Double(5.0));
		Assert.assertEquals(transaction.getTypeTransaction(), TypeTransaction.DEBIT);

		Assert.assertEquals(transaction.getValueForSum(), new Double(-5.0));
	}

	@Test
	public void testIfBuildANewTransactionAndIsFinishThenTheTypeTransactionIsFINISH() {
		Transaction transaction = new Transaction(TypeTransaction.DEBIT, new Double(5.0));
		transaction.setFinish();
		Assert.assertEquals(transaction.getTypeStatusTransaction(), TypeStatusTransaction.FINISH);
	}

	@Test
	public void testIfBuildANewTransactionAndIsRejectedThenTheTypeTransactionIsRejected() {
		Transaction transaction = new Transaction(TypeTransaction.DEBIT, new Double(5.0));
		transaction.setRejected();
		Assert.assertEquals(transaction.getTypeStatusTransaction(), TypeStatusTransaction.REJECTED);
		Assert.assertFalse(transaction.isNotRejected());

	}
}
