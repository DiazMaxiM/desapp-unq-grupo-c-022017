package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Account {
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	public Integer countTransaction() {
		return transactions.size();
	}

	public Double balance() {
		return transactions.stream().mapToDouble( trans -> trans.getValueForSum()).sum();
	}
	
}
