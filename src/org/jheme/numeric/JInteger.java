package org.jheme.numeric;

public class JInteger extends JNumber {
	private final int _val;

	public JInteger(int val) {
		_val = val;
	}

	@Override
	public Number add(JNumber v) {
		return v.addInteger(_val);
	}
	@Override
	public Number sub(JNumber v) {
		return v.subInteger(_val);
	}
	@Override
	public Number mul(JNumber v) {
		return v.mulInteger(_val);
	}
	@Override
	public Number div(JNumber v) {
		return v.divInteger(_val);
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
