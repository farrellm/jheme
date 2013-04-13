package org.jheme.core;

import java.util.Collection;

public class ArgumentException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public static void expected(int n, Collection<?> args) {
		if (args.size() != n)
			throw new ArgumentException(n);
	}
	
	public ArgumentException(int n) {
		super("expected " + n + " arguments");
	}
}
