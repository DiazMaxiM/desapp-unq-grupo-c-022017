package model;

public class Money extends Entity {

	private static final long serialVersionUID = 1L;
	private Symbol symbol;

	public Money() {

	}

	public Money(Symbol symbol) {
		this.setSymbol(symbol);
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
}