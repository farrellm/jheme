package org.jheme.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Eval {
	final List<Map<Symbol, Object>> _env = new LinkedList<>();
	
	protected Object lookup(Symbol sym) {
		Iterator<Map<Symbol, Object>> iter = _env.iterator();
		while (iter.hasNext()) {
			Map <Symbol, Object> m = iter.next();
			if (m.containsKey(sym))
				return m.get(sym);
		}
		throw new RuntimeException("undefined symbol " + sym);
	}
	
	public Object eval(Object obj) {
		if (obj instanceof Number ||
			obj instanceof String)
			return obj;
		if (obj instanceof Symbol)
			return lookup((Symbol)obj);
		if (obj instanceof List)
			return evalApply((List<?>)obj);
		
		throw new RuntimeException(
			"can't eval " + obj + ", unknown type");
	}
	
	private static final Symbol _begin = new Symbol("begin");
	private static final Symbol _if = new Symbol("if");
	private static final Symbol _lambda = new Symbol("lambda");
	private static final Symbol _let = new Symbol("let");
	
	protected Object evalApply(List<?> lst) {
		Object op = lst.get(0);
		List<?> args = lst.subList(1, lst.size());
		if (op instanceof Symbol) {
			
		}
			
		return null;
	}
}
