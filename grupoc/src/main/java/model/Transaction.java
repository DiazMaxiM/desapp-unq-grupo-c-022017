package model;

import java.util.List;

public class Transaction {
	private TypeTransaction typeTransaction;
	private float value;
	
	
	public Transaction(TypeTransaction typeTransaction, float value) {
		
		this.typeTransaction  =typeTransaction;
		this.value = value;
	}
	public float getValue(){
		return value;
	}
	public TypeTransaction getTypeTransaction() {
		return typeTransaction;
	}
	
}
