package model;

import java.util.HashSet;
import java.util.Set;

import exception.BalanceInsufficient;

public class Account extends Entity {
	private Set<Transaction> transactions = new HashSet<Transaction>();

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
