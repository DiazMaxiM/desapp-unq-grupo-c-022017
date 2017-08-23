package model;

public class Transaction {
	private TypeTransaction typeTransaction;
	private Double value;
	
	
	public Transaction(TypeTransaction typeTransaction, Double value) {
		
		this.typeTransaction  =typeTransaction;
		this.value = value;
	}
	public Double getValueForSum(){
		if (this.getTypeTransaction().equals(TypeTransaction.CREDIT)){
			return getValue();
		}
		return - getValue();
	}
	public TypeTransaction getTypeTransaction() {
		return typeTransaction;
	}
	public Double getValue() {
		return value;
	}
	
}
