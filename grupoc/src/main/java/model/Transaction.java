package model;

public class Transaction {
	private TypeTransaction typeTransaction;
	private Double value;
	private StatusTransaction statusTransaction = StatusTransaction.PENDING;

	public Transaction(TypeTransaction typeTransaction, Double value) {

		this.typeTransaction = typeTransaction;
		this.value = value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getValueForSum() {
		if (this.getTypeTransaction().equals(TypeTransaction.CREDIT)) {
			return getValue();
		}
		return -getValue();
	}

	public TypeTransaction getTypeTransaction() {
		return typeTransaction;
	}

	public Double getValue() {
		return value;
	}

	public void setFinish() {
		this.statusTransaction = StatusTransaction.FINISH;
	}

	public Boolean isNotRejected() {

		return this.statusTransaction != StatusTransaction.REJECTED;
	}

	public void setRejected() {
		this.statusTransaction = StatusTransaction.REJECTED;

	}

}
