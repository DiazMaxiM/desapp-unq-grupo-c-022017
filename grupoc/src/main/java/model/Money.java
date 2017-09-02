package model;

public class Money {
	
    private Symbol symbol;
    
    public Money(Symbol symbol){
   	 this.setSymbol(symbol);
    }

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
}