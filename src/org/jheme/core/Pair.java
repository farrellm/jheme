package org.jheme.core;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Pair<E> extends AbstractSequentialList<E> {
	final private E _car;
	final private Pair<E> _cdr;
	
	public Pair(E car, Pair<E> cdr) {
		_car = car;
		_cdr = cdr;
	}
	
	public E car() {
		return _car;
	}
	public Pair<E> cdr() {
		return _cdr;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new pair_iterator(this);
	}
	@Override
	public ListIterator<E> listIterator(int n) {
		return new pair_list_iterator(this, n);
	}
	
	@Override
	public int size() {
		ListIterator<E> i = listIterator();
		while (i.hasNext())
			i.next();
		return i.nextIndex();
	}
	
	private class pair_iterator implements Iterator<E> {
		private Pair<E> _cur;
		private int _index;

		pair_iterator(Pair<E> p) {
			_cur = p;
			_index = 0;
		}

		@Override
		public boolean hasNext() {
			return _cur != null;
		}

		@Override
		public E next() {
			final E v = _cur._car;
			_cur = _cur._cdr;
			_index++;
			return v;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	private class pair_list_iterator implements ListIterator<E> {
		private Pair<E> _cur;
		private int _index;

		pair_list_iterator(Pair<E> p, int n) {
			_cur = p;
			_index = 0;
			
			while(n-- > 0)
				next();
		}

		@Override
		public boolean hasNext() {
			return _cur != null;
		}
		
		@Override
		public boolean hasPrevious() {
			return false;
		}

		@Override
		public E next() {
			final E v = _cur._car;
			_cur = _cur._cdr;
			_index++;
			return v;
		}
		
		@Override
		public E previous() {
			throw new NoSuchElementException();
		}

		@Override
		public int nextIndex() {
			return _index;
		}

		@Override
		public int previousIndex() {
			return _index - 1;
		}

		@Override
		public void add(E arg0) {
			throw new UnsupportedOperationException();
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		@Override
		public void set(E arg0) {
			throw new UnsupportedOperationException();
		}
	}

}
