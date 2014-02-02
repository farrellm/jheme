package org.jheme.core;

import java.util.HashMap;
import java.util.Map;

public class Symbol {
	final private static Map<String, Symbol> _symbols =
			new HashMap<String, Symbol>();

	final private String _symbol;

	private Symbol(String symbol) {
		_symbol = symbol.intern();
	}

	public static Symbol getInstance(String symbol) {
		if (!_symbols.containsKey(symbol))
			_symbols.put(symbol, new Symbol(symbol));
		return _symbols.get(symbol);
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
