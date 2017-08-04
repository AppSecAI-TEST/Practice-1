package data.oops.calculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
	MathOperation add;
	MathOperation subtract;
//	MathOperation multiply;
//	MathOperation divide;
//	MathOperation modulo;
	
	Map<Character, MathOperation> mapper = new HashMap<Character, MathOperation>();
	
	public Calculator() {
		super();
		add = new Addition();
		subtract = new Subtraction();
//		multiply = new MathOperation();
//		divide = new MathOperation();
		
		mapper.put('+', add);
		mapper.put('-', subtract);
//		mapper.put('*', multiply);
//		mapper.put('/', divide);
	}

	public float calculate(char operation, int a, int b) {
		return mapper.get(operation).calc(a, b);
	}

}
