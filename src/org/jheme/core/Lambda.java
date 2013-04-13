package org.jheme.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Lambda {
	private final Eval _env;
	private final List<Symbol> _names;
	private final List<?> _body;
	
	public Lambda(Eval env, List<Symbol> args, List<?> body) {
		_env = env;
		_names = args;
		_body = body;
	}

	public Map<Symbol, Object> getExt(List<?> args) {
		ArgumentException.expected(_names.size(), args);
		
		Iterator<Symbol> sym = _names.iterator();
		Iterator<?> val = args.iterator();
		
		Map<Symbol, Object> ext = new HashMap<Symbol, Object>();
		
		while (sym.hasNext())
			ext.put(sym.next(), val.next());
		
		return ext;
	}
	
	public Object getBody() {
		return _body;
	}
	
	public Object doCall(List<?> args) {
		return new Eval(_env, getExt(args)).evalSequence(_body);
	}
}
