package math;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class MyMathTest {
    private MyMath myMath;

    @Before
    public void setUp() {
        myMath = new MyMath();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_factorial_nLessThanZero() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("n should be 0 <= n <= 12");
        myMath.factorial(-1);
    }

    @Test
    public void test_factorial_nGreaterThanTwelve() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("n should be 0 <= n <= 12");
        myMath.factorial(13);
    }

    @Test
    public void test_isPrime_nLessThanTwo() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("n should be >= 2");
        myMath.isPrime(0);
    }

    @Test
    public void test_isPrime() {
        Assert.assertTrue(myMath.isPrime(2));
        Assert.assertTrue(myMath.isPrime(3));
        Assert.assertTrue(myMath.isPrime(5));
        Assert.assertTrue(myMath.isPrime(7));
        Assert.assertTrue(myMath.isPrime(11));
        Assert.assertTrue(myMath.isPrime(107));
        Assert.assertTrue(myMath.isPrime(7229));

        Assert.assertFalse(myMath.isPrime(4));
        Assert.assertFalse(myMath.isPrime(6));
        Assert.assertFalse(myMath.isPrime(8));
        Assert.assertFalse(myMath.isPrime(9));
        Assert.assertFalse(myMath.isPrime(77));
        Assert.assertFalse(myMath.isPrime(729));
        Assert.assertFalse(myMath.isPrime(7777));
    }
}
