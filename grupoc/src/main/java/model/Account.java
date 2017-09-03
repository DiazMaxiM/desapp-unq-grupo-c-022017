package model;

import java.util.ArrayList;
import java.util.List;

import exception.BalanceInsufficient;

public class Account {
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public void addTransaction(Transaction transaction) throws BalanceInsufficient {
		if (isBalanceInsufficient(transaction)) {
			throw new BalanceInsufficient("Error saldo insuficiente");
		}
		transactions.add(transaction);
	}

	private boolean isBalanceInsufficient(Transaction transaction) {
		return (this.balance() + transaction.getValueForSum()) < 0;
	}

	public Integer countTransaction() {
		return transactions.size();
	}

	public Double balance() {
		return transactions.stream().filter(trans -> trans.isNotRejected()).mapToDouble(trans -> trans.getValueForSum())
				.sum();
	}

}
