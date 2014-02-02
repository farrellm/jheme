package org.jheme.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Lambda extends FunctionN {
	private final Eval _env;
	private final List<Symbol> _names;
	private final List<?> _body;

	public Lambda(Eval env, List<Symbol> args, List<?> body) {
		super("<lambda>");
		_env = env;
		_names = args;
		_body = body;
	}

	private Map<Symbol, Object> extendEnv(List<?> args) {
		ArgumentException.expected(_names.size(), args);

		Iterator<Symbol> sym = _names.iterator();
		Iterator<?> val = args.iterator();

		Map<Symbol, Object> ext = new HashMap<Symbol, Object>();

		while (sym.hasNext())
			ext.put(sym.next(), val.next());

		return ext;
	}

	@Override
	public Object apply(List<Object> args) {
		return new Eval(_env, extendEnv(args)).evalSequence(_body);
	}
}
