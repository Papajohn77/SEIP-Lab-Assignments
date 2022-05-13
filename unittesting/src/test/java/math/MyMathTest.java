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
}
