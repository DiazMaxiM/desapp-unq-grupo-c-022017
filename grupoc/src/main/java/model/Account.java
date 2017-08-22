package model;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	public Integer countTransaction() {
		return transactions.size();
	}
	
}
