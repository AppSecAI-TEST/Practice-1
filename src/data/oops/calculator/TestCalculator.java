package data.oops.calculator;

public class TestCalculator {
/**
 * Give '+' for addition , '-' for subtraction,...and so on
 * @param args
 */
	public static void main(String[] args) {
		int a = 10, b = 2;
		Calculator c = new Calculator();
		System.out.println("addition is = "+ c.calculate('+', a, b));
		System.out.println("subtraction is = "+ c.calculate('-', a, b));
	}

}
