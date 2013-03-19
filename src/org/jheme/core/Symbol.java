package org.jheme.core;

public class Symbol {
	final private String _symbol;

	public Symbol(String symbol) {
		_symbol = symbol.intern();
	}
	
	@Override
	public int hashCode() {
		return _symbol.hashCode();
	}
	
	@Override
	public String toString() {
		return "'" + _symbol;
	}
	
	@Override
	public boolean equals(Object sym) {
		return ((Symbol)sym)._symbol.equals(_symbol);
	}
}
