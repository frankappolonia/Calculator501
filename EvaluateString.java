
import java.util.ArrayList;
import java.util.Stack;

public class EvaluateString {
	public static double evaluate(String expression) throws Exception {
		char[] tokens = expression.toCharArray();

		// Stack for numbers: 'values'
		Stack<Double> values = new Stack<Double>();

		// Stack for Operators: 'ops'
		Stack<Character> ops = new Stack<Character>();

		Boolean negation = false;

		for (int i = 0; i < tokens.length; i++) {

			// Current token is a
			// whitespace, skip it
			if (tokens[i] == ' ')
				continue;

			if (tokens[i] == '-') {
				if (i == 0) {
					if (negation) {
						negation = false;
					} else {
						negation = true;
					}

					continue;
				} 
				else {
					ArrayList<Character> operators = new ArrayList<Character>();
					operators.add('+');
					operators.add('-');
					operators.add('*');
					operators.add('/');
					operators.add('^');
					operators.add('(');
					operators.add(')');
					if (operators.contains(tokens[i - 1])) {
						ArrayList<Character> nonBracketOperators = new ArrayList<Character>();
						nonBracketOperators.add('+');
						nonBracketOperators.add('-');
						nonBracketOperators.add('*');
						nonBracketOperators.add('/');
						nonBracketOperators.add('^');
						
						if (i > 1 && nonBracketOperators.contains(tokens[i - 2])) {
							// do something
							throw new Exception("Bad input");
						}
						if (negation) {
							negation = false;
						} else {
							negation = true;
						}

						continue;
					}
				}
			}

			// Current token is a number,
			// push it to stack for numbers
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();

				// There may be more than one
				// digits in number
				while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9' || (tokens[i]=='.')))
					sbuf.append(tokens[i++]);
				double numberToPush = Double.parseDouble(sbuf.toString());
				if (negation) {
					negation = false;
					numberToPush *= -1;
					values.push(numberToPush);
				} else {
					values.push(numberToPush);
				}

				// right now the i points to
				// the character next to the digit,
				// since the for loop also increases
				// the i, we would skip one
				// token position; we need to
				// decrease the value of i by 1 to
				// correct the offset.
				i--;
			}

			// Current token is an opening brace,
			// push it to 'ops'
			else if (tokens[i] == '(')
				// Exception for when there is no operator before parentehses ( -> 2+4(7)
				if (i >  0  && tokens[i-1] != '+' && tokens[i-1] != '-' && tokens[i-1] != '*' && tokens[i-1] != '/' && tokens[i-1] != '^')
					throw new Exception("operator must come before '('");
				else
					ops.push(tokens[i]);

			// Closing brace encountered,
			// solve entire brace
			else if (tokens[i] == ')') {
				// Exception for when there is no operator after parentehses ) -> (9)2
				if (tokens.length > i + 1 && tokens[i+1] != '+' && tokens[i+1] != '-' && tokens[i+1] != '*' && tokens[i+1] != '/' && tokens[i+1] != '^')
				throw new Exception("operator must follow ')'");

				// Otherwise, runs while loop 
				while (ops.peek() != '(')
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				ops.pop();
			}

			// If current token is an operator.
			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '^') {
				// While top of 'ops' has same
				// or greater precedence to current
				// token, which is an operator.
				// Apply operator on top of 'ops'
				// to top two elements in values stack

				if (tokens[i] == '+' && tokens[i+1] == '+' && i+1 < tokens.length)
					// check for invalid input of double operator ++
					throw new Exception("Cannot have double operator (++)");
				if (tokens[i] == '/' && tokens[i+1] == '/' && i+1 < tokens.length)
					// check for invalid input of double operator //
					throw new Exception("Cannot have double operator (//)");
				
				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
					// while the ops stack isnt empty and the token has presedence over the next
					// operator at the top of the stack
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
					// pop last two values at the end of values stack and calculate them, adding
					// result to values stack

				// Push current token to 'ops'.
				ops.push(tokens[i]);
			}
		}

		// Entire expression has been
		// parsed at this point, apply remaining
		// ops to remaining values
		while (!ops.empty())
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));

		// Top of 'values' contains
		// result, return it
		return values.pop();
	}

	// Returns true if 'op2' has higher
	// or same precedence as 'op1',
	// otherwise returns false.
	public static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op2 == '^' && op1 == ')') || (op2 == '^' && op1 == '('))
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	// A utility method to apply an
	// operator 'op' on operands 'a'
	// and 'b'. Return the result.
	public static double applyOp(char op, double b, double a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '^':
			return Math.pow(a, b); 
		case '/':
			if (b == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		return 0;
	}
	
	// wrapper method to call evaluate
	public static String evaluateExpression(String inputString) {
		try {
			return EvaluateString.evaluate(inputString) + "";
		} catch (Exception e) {
			return "Invalid Input: " + e.getMessage();
		}
		
	}

	// Driver method to test above methods
	public static void main(String[] args) {
		String inputString = "1.2/-2";

		System.out.println(evaluateExpression(inputString));

	}
}