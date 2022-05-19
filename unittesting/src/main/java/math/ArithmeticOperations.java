package math;

/**
* The ArithmeticOperations provides simple arithmetic operations
* that serve as hands-on practice on Unit Testing.
*/
public class ArithmeticOperations {

	/**
	 * Performs the basic arithmetic operation of division.
	 * @param numerator the numerator of the operation
	 * @param denominator the denominator of the operation
	 * @return the result of the division between numerator and denominator
	 * @exception ArithmeticException when denominator is zero 
	 */
	public double divide(double numerator, double denominator) {
		if (denominator == 0) throw new ArithmeticException("Cannot divide with zero");

		return numerator/denominator;
	}

	/**
	 * Performs the basic arithmetic operation of multiplication 
	 * between two non negative Integers
	 * @param x the first input
	 * @param y the second input
	 * @return the product of the multiplication
	 * @exception IllegalArgumentException when <b>x</b> or <b>y</b> are negative numbers 
	 * @exception IllegalArgumentException when the product does not fit in an Integer variable 
	 */
	public int multiply(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("x & y should be >= 0");
		}

		if (y != 0 && x > Integer.MAX_VALUE/y) {
			throw new IllegalArgumentException("The product does not fit in an Integer variable");			
		}

		return x*y;	
	}
}
