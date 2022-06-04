package math;

/**
* The MyMath provides simple methematical operations
* that serve as hands-on practice on Unit Testing.
*/
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

    /**
	 * Checks if the given integer number is a prime number.
	 * @param n the number we want to check if it is prime
	 * @return true if n is a prime number else false
	 * @exception IllegalArgumentException when n < 2
	 */
    public boolean isPrime(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("n should be >= 2");
        } else if (n == 2 || n == 3) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i < Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
