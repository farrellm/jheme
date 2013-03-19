package org.jheme.core;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Eval {
	final List<Map<Symbol, Object>> _env = new LinkedList<>();
	
	public Object eval(Object obj) {
		if (obj instanceof Number ||
			obj instanceof String)
			return obj;
		
		return null;
	}
}
