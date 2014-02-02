package org.jheme.numeric;

public class Wrap {
	public static JNumber wrap(Object n) {
		if (n instanceof Integer)
			return new JInteger((Integer)n);
		if (n instanceof Long)
			return new JLong((Long)n);
		if (n instanceof Float)
			return new JFloat((Float)n);
		if (n instanceof Double)
			return new JDouble((Double)n);

		throw new RuntimeException("not a number: " + n.toString());
	}

	public static Number add(Object a1, Object a2) {
		return Wrap.wrap(a1).add(Wrap.wrap(a2));
	}
	public static Number sub(Object a1, Object a2) {
		return Wrap.wrap(a1).sub(Wrap.wrap(a2));
	}
	public static Number mul(Object a1, Object a2) {
		return Wrap.wrap(a1).mul(Wrap.wrap(a2));
	}
	public static Number div(Object a1, Object a2) {
		return Wrap.wrap(a1).div(Wrap.wrap(a2));
	}
}
