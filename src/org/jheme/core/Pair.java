package org.jheme.core;

import java.util.Iterator;
import java.util.AbstractSequentialList<E>;

public class Pair<E> extends AbstractSequentialList<E> {
	private class pair_iterator<E> implements Iterator<E> {
		private Pair<E> _cur;

		pair_iterator(Pair<e> p) {
			_cur = p;
		}

		@Override
		public boolean hasNext() {
			return _cur.cdr != null;
		}

		@Override
		public E next() {
			final E v = _cur.car;
			_cur = _cur.cdr;
			return v;
		}
	}

	final private E _car;
	final private Pair<E> _cdr;

}
