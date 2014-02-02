package org.jheme.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	private static Pattern _tokenPattern =
		Pattern.compile("\\(|\\)|['`~,\\.]|[\\w!@#$%^&*-=+?/]+|\"[^\"]*\"|\\S");
	public static List<String> tokens(String str) {
		List<String> tokens = new LinkedList<>();
		Matcher m = _tokenPattern.matcher(str);
		
		while (m.find())
			tokens.add(m.group());
		
		return tokens;
	}

	public static List<Object> parse(List<String> tokens) {
		tokens.add(")");
		return parse(tokens.iterator());
	}
	
	private static List<Object> parse(Iterator<String> iter) {
		List<Object> lst = new LinkedList<>();
		
		while (iter.hasNext()) {
			String t = iter.next();
			if ("(".equals(t))
				lst.add(parse(iter));
			else if (")".equals(t))
				return lst;
			else
				lst.add(parse(t));
		}
		
		throw new RuntimeException("missing ')'");
	}
	
	private static final Pattern _str = Pattern.compile("\"(.*)\"");
	private static final Pattern _int = Pattern.compile("-?\\d+");
	private static final Pattern _flt = Pattern.compile("-?\\d+\\.\\d*");

	private static Object parse(String str) {
		Matcher m;
		m = _str.matcher(str);
		if (m.matches())
			return m.group(1);
		if (_int.matcher(str).matches())
			return Integer.parseInt(str);
		if (_flt.matcher(str).matches())
			return Double.parseDouble(str);
		if ("true".equals(str))
			return Boolean.TRUE;
		if ("false".equals(str))
			return Boolean.FALSE;
		if ("null".equals(str))
			return null;
		return new Symbol(str);
	}
}
