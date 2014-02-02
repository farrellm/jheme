package org.jheme.core;

import java.util.ArrayList;
import java.util.List;

abstract public class FunctionN extends Form {
	public FunctionN() {}
	public FunctionN(String name) {
		super(name);
	}

	@Override
	public Object doCall(Eval eval, List<?> args) {
		List<Object> eArgs = new ArrayList<Object>(args.size());
		for (Object a : args)
			eArgs.add(eval.eval(a));

		return apply(eArgs);
	}

	abstract protected Object apply(List<Object> args);
}
