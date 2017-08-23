package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import exception.BalanceInsufficient;

public class Account {
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public void addTransaction(Transaction transaction) throws BalanceInsufficient  {
		if (transaction.getTypeTransaction() == TypeTransaction.DEBIT && this.balance() < transaction.getValue()){
			throw new BalanceInsufficient(null);
		}
			transactions.add(transaction);
	}

	public Integer countTransaction() {
		return transactions.size();
	}

	public Double balance() {
		return transactions.stream().mapToDouble( trans -> trans.getValueForSum()).sum();
	}
	
}
