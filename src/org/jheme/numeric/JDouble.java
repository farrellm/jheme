package org.jheme.numeric;

public class JDouble extends JNumber {
	private final double _val;

	public JDouble(double val) {
		_val = val;
	}

	@Override
	public Number add(JNumber v) {
		return v.addDouble(_val);
	}
	@Override
	public Number sub(JNumber v) {
		return v.subDouble(_val);
	}
	@Override
	public Number mul(JNumber v) {
		return v.mulDouble(_val);
	}
	@Override
	public Number div(JNumber v) {
		return v.divDouble(_val);
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
