package org.jheme.core;

import java.util.List;

public abstract class Form {
	final private String _name;

	public Form() {
		_name = null;
	}

	public Form(String name) {
		_name = name;
	}

	@Override
	public String toString() {
		if (_name != null)
			return _name;
		return "<unnamed>";
	}

	abstract public Object doCall(Eval eval, List<?> args);
}
