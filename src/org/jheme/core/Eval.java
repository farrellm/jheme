package org.jheme.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Eval {
	final Pair<Map<Symbol, Object>> _env;

	public Eval() {
		_env = new Pair<Map<Symbol, Object>>(new HashMap<Symbol, Object>(), null);
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

	private static final Symbol _define = new Symbol("define");
	private static final Symbol _begin = new Symbol("begin");
	private static final Symbol _if = new Symbol("if");
	private static final Symbol _lambda = new Symbol("lambda");
	private static final Symbol _quote = new Symbol("quote");

	protected Object evalApply(List<?> lst) {
		Object op = lst.get(0);
		List<?> args = lst.subList(1, lst.size());

		if (op instanceof Symbol) {
			if (op.equals(_define))
				return evalDefine(args);
			if (op.equals(_begin))
				return evalSequence(args);
			if (op.equals(_if))
				return evalIf(args);
			if (op.equals(_quote))
				return evalQuote(args);
			if (op.equals(_lambda))
				return evalLambda(args);
		}

		Object l = eval(op);
		List<Object> eArgs = new ArrayList<Object>(args.size());
		for (Object a : args)
			eArgs.add(eval(a));

		if (l instanceof Form)
			return ((Form) l).doCall(eArgs);

		throw new RuntimeException("Cannot apply " + l.toString());
	}

	protected Object evalDefine(List<?> args) {
		ArgumentException.expected(2, args);

		Iterator<?> iter = args.iterator();
		Symbol name = (Symbol)iter.next();
		Object val = iter.next();

		_env.car().put(name, eval(val));

		return null;
	}

	protected Object evalIf(List<?> args) {
		ArgumentException.expected(3, args);

		Iterator<?> iter = args.iterator();
		Object p = iter.next();
		Object t = iter.next();
		Object f = iter.next();

		if ((Boolean)eval(p))
			return eval(t);
		else
			return eval(f);
	}

	protected Object evalQuote(List<?> args) {
		ArgumentException.expected(1, args);

		Iterator<?> iter = args.iterator();
		return iter.next();
	}

	@SuppressWarnings("unchecked")
	protected Lambda evalLambda(List<?> args) {
		List<Symbol> vals = (List<Symbol>)args.get(0);
		List<?> body = args.subList(1, args.size());
		return new Lambda(this, vals, body);
	}
}
