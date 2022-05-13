package math;

public class MyMath {

    /**
	 * Computes the factorial of a given integer number 0 <= n <= 12
	 * @param n the number whose factorial we want to compute
	 * @return the factorial of the number n
	 * @exception IllegalArgumentException when n < 0 or n > 12
	 */
    public int factorial(int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException("n should be 0 <= n <= 12");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
