package org.jheme.core;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Eval {
	final Pair<Map<Symbol, Object>> _env;

	public Eval() {
		_env = RootEnvironment.extendRoot();
	}

	public Eval(Eval base, Map<Symbol, Object> ext) {
		_env = new Pair<Map<Symbol, Object>>(ext, base._env);
	}

	public Object lookup(Symbol sym) {
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
			obj instanceof String ||
			obj instanceof Boolean)
			return obj;
		if (obj instanceof Symbol)
			return lookup((Symbol)obj);
		if (obj instanceof List)
			return evalApply((List<?>)obj);

		throw new RuntimeException(
			"can't eval " + obj + ", unknown type");
	}

	public Object evalSequence(List<?> args) {
		Iterator<?> iter = args.iterator();
		Object v = null;

		while (iter.hasNext())
			v = eval(iter.next());

		return v;
	}

	protected Object evalApply(List<?> lst) {
		Object op = lst.get(0);
		List<?> args = lst.subList(1, lst.size());

		Object l = eval(op);
		if (l instanceof Form)
			return ((Form) l).doCall(this, args);

		throw new RuntimeException("Cannot apply " + l.toString());
	}

	public void define(Symbol name, Object value) {
		_env.car().put(name, value);
	}
}
