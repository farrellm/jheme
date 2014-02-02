package org.jheme.numeric;

public abstract class JNumber {
	abstract public Number add(JNumber v);
	abstract public Number sub(JNumber v);
	abstract public Number mul(JNumber v);
	abstract public Number div(JNumber v);

	abstract public Number addInteger(int v);
	abstract public Number addLong(long v);
	abstract public Number addFloat(float v);
	abstract public Number addDouble(double v);

	abstract public Number subInteger(int v);
	abstract public Number subLong(long v);
	abstract public Number subFloat(float v);
	abstract public Number subDouble(double v);

	abstract public Number mulInteger(int v);
	abstract public Number mulLong(long v);
	abstract public Number mulFloat(float v);
	abstract public Number mulDouble(double v);

	abstract public Number divInteger(int v);
	abstract public Number divLong(long v);
	abstract public Number divFloat(float v);
	abstract public Number divDouble(double v);
}
