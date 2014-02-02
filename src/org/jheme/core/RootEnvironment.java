package org.jheme.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RootEnvironment {
	private static final Pair<Map<Symbol, Object>> _rootEnv;

	static {
		final Map<Symbol, Object> env = new HashMap<Symbol, Object>();
		_rootEnv = new Pair<Map<Symbol, Object>>(env, null);

		// special forms
		env.put(Symbol.getInstance("define"), new Form("define") {
			@Override
			public Object doCall(Eval eval, List<?> args) {
				ArgumentException.expected(2, args);

				Iterator<?> iter = args.iterator();
				Symbol name = (Symbol)iter.next();
				Object val = iter.next();

				eval.define(name, eval.eval(val));

				return null;
			}
		});
		env.put(Symbol.getInstance("if"), new Form("if") {
			@Override
			public Object doCall(Eval eval, List<?> args) {
				ArgumentException.expected(3, args);

				Iterator<?> iter = args.iterator();
				Object p = iter.next();
				Object t = iter.next();
				Object f = iter.next();

				if ((Boolean)eval.eval(p))
					return eval.eval(t);
				else
					return eval.eval(f);
			}
		});
		env.put(Symbol.getInstance("begin"), new Form("begin") {
			@Override
			public Object doCall(Eval eval, List<?> args) {
				return eval.evalSequence(args);
			}
		});
		env.put(Symbol.getInstance("lambda"), new Form("lambda") {
			@Override
			public Object doCall(Eval eval, List<?> args) {
				@SuppressWarnings("unchecked")
				List<Symbol> vals = (List<Symbol>)args.get(0);
				List<?> body = args.subList(1, args.size());
				return new Lambda(eval, vals, body);
			}
		});
		env.put(Symbol.getInstance("quote"), new Form("quote") {
			@Override
			public Object doCall(Eval eval, List<?> args) {
				ArgumentException.expected(1, args);

				Iterator<?> iter = args.iterator();
				return iter.next();
			}
		});

		// functions
		env.put(Symbol.getInstance("quit"), new Function("quit"){
			@Override
			protected Object apply() {
				System.exit(0);
				return null;
			}

			@Override
			protected Object apply(Object a1) {
				System.exit((Integer)a1);
				return null;
			}
		});
	}

	public static Pair<Map<Symbol, Object>> extendRoot() {
		return new Pair<Map<Symbol, Object>>(new HashMap<Symbol, Object>(), _rootEnv);
	}
}
