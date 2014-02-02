package org.jheme.numeric;

public class JLong extends JNumber {
	private final long _val;

	public JLong(long val) {
		_val = val;
	}

	@Override
	public Number add(JNumber v) {
		return v.addLong(_val);
	}
	@Override
	public Number sub(JNumber v) {
		return v.subLong(_val);
	}
	@Override
	public Number mul(JNumber v) {
		return v.mulLong(_val);
	}
	@Override
	public Number div(JNumber v) {
		return v.divLong(_val);
	}

	@Override
	public Number addInteger(int v) {
		return v + _val;
	}
	@Override
	public Number addLong(long v) {
		return v + _val;
	}
	@Override
	public Number addFloat(float v) {
		return v + _val;
	}
	@Override
	public Number addDouble(double v) {
		return v + _val;
	}


	@Override
	public Number subInteger(int v) {
		return v - _val;
	}
	@Override
	public Number subLong(long v) {
		return v - _val;
	}
	@Override
	public Number subFloat(float v) {
		return v - _val;
	}
	@Override
	public Number subDouble(double v) {
		return v - _val;
	}

	@Override
	public Number mulInteger(int v) {
		return v * _val;
	}
	@Override
	public Number mulLong(long v) {
		return v * _val;
	}
	@Override
	public Number mulFloat(float v) {
		return v * _val;
	}
	@Override
	public Number mulDouble(double v) {
		return v * _val;
	}

	@Override
	public Number divInteger(int v) {
		return v / _val;
	}
	@Override
	public Number divLong(long v) {
		return v / _val;
	}
	@Override
	public Number divFloat(float v) {
		return v / _val;
	}
	@Override
	public Number divDouble(double v) {
		return v / _val;
	}
}
