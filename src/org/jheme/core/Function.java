package org.jheme.core;

import java.util.Iterator;
import java.util.List;

abstract public class Function extends Form {
	public Function() {}
	public Function(String name) {
		super(name);
	}

	@Override
	public Object doCall(Eval eval, List<?> args) {
		if (args.isEmpty())
			return apply();

		final Iterator<?> iter = args.iterator();

		final Object a1 = eval.eval(iter.next());
		if (!iter.hasNext())
			return apply(a1);
		final Object a2 = eval.eval(iter.next());
		if (!iter.hasNext())
			return apply(a1, a2);
		final Object a3 = eval.eval(iter.next());
		if (!iter.hasNext())
			return apply(a1, a2, a3);
		final Object a4 = eval.eval(iter.next());
		if (!iter.hasNext())
			return apply(a1, a2, a3, a4);
		final Object a5 = eval.eval(iter.next());
		if (!iter.hasNext())
			return apply(a1, a2, a3, a4, a5);

		throw new UnsupportedOperationException("no functions with more than 5 arguments");
	}

	protected Object apply() {
		throw new UnsupportedOperationException(
				"incorrect number of arguments for '" + toString() + "': 0");
	}

	protected Object apply(Object a1) {
		throw new UnsupportedOperationException(
				"incorrect number of arguments for '" + toString() + "': 1");
	}

	protected Object apply(Object a1, Object a2) {
		throw new UnsupportedOperationException(
				"incorrect number of arguments for '" + toString() + "': 2");
	}

	protected Object apply(Object a1, Object a2, Object a3) {
		throw new UnsupportedOperationException(
				"incorrect number of arguments for '" + toString() + "': 3");
	}

	protected Object apply(Object a1, Object a2, Object a3, Object a4) {
		throw new UnsupportedOperationException(
				"incorrect number of arguments for '" + toString() + "': 4");
	}

	protected Object apply(Object a1, Object a2, Object a3, Object a4, Object a5) {
		throw new UnsupportedOperationException(
				"incorrect number of arguments for '" + toString() + "': 5");
	}
}
