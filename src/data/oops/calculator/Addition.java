package data.oops.calculator;

public class Addition implements MathOperation{
	@Override
	public float calc(int a, int b) {
		return (a + b);
	}
}
