package model;

public class Transaction {
	private TypeTransaction typeTransaction;
	private Double value;
	
	
	public Transaction(TypeTransaction typeTransaction, Double value) {
		
		this.typeTransaction  =typeTransaction;
		this.value = value;
	}
	public Double getValueForSum(){
		if (this.typeTransaction.equals(TypeTransaction.CREDIT)){
			return value;
		}
		return -value;
	}
	public TypeTransaction getTypeTransaction() {
		return typeTransaction;
	}
	
}
