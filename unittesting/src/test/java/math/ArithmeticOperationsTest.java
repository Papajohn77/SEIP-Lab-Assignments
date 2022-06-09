package math;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ArithmeticOperationsTest {
    private static final double DELTA = 1e-10;
    private ArithmeticOperations arithmeticOperations;

    @Before
    public void setUp() {
        arithmeticOperations = new ArithmeticOperations();
    }

    @Test
    public void test_devide_sameSignNumbers() {
        Assert.assertEquals(
            5.0,
            arithmeticOperations.divide(10.0, 2.0),
            DELTA);
        Assert.assertEquals(
            3.3333333333,
            arithmeticOperations.divide(10.0, 3.0),
            DELTA);

        Assert.assertEquals(
            5.0,
            arithmeticOperations.divide(-10.0, -2.0),
            DELTA);
        Assert.assertEquals(
            3.3333333333,
            arithmeticOperations.divide(-10.0, -3.0),
            DELTA);
    }

    @Test
    public void test_devide_oppositeSignNumbers() {
        Assert.assertEquals(
            -5.0,
            arithmeticOperations.divide(-10.0, 2.0),
            DELTA);
        Assert.assertEquals(
            -3.3333333333,
            arithmeticOperations.divide(-10.0, 3.0),
            DELTA);

        Assert.assertEquals(
            -5.0,
            arithmeticOperations.divide(10.0, -2.0),
            DELTA);
        Assert.assertEquals(
            -3.3333333333,
            arithmeticOperations.divide(10.0, -3.0),
            DELTA);
    }

    @Test
    public void test_devide_zeroNumerator() {
        Assert.assertEquals(
            0.0,
            arithmeticOperations.divide(0.0, 10.0),
            DELTA);

        Assert.assertEquals(
            0.0,
            arithmeticOperations.divide(0.0, -10.0),
            DELTA);
    }

    @Test (expected = ArithmeticException.class)
    public void test_devide_zeroDenominator() {
        arithmeticOperations.divide(10.0, 0.0);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_multiply_positiveNumbers() {
        Assert.assertEquals(14, arithmeticOperations.multiply(2, 7));
        Assert.assertEquals(56, arithmeticOperations.multiply(7, 8));
    }

    @Test
    public void test_multiply_zeroNumbers() {
        Assert.assertEquals(0, arithmeticOperations.multiply(0, 7));
        Assert.assertEquals(0, arithmeticOperations.multiply(7, 0));
        Assert.assertEquals(0, arithmeticOperations.multiply(0, 0));
    }

    @Test
    public void test_multiply_negativeNumbers() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        arithmeticOperations.multiply(-2, -7);
    }

    @Test
    public void test_multiply_negativeX() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        arithmeticOperations.multiply(-2, 7);
    }

    @Test
    public void test_multiply_negativeY() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        arithmeticOperations.multiply(2, -7);
    }

    @Test
    public void test_multiply_integerOverflow() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The product does not fit in an Integer variable");
        arithmeticOperations.multiply(Integer.MAX_VALUE, 2);
    }

    @Test
    public void test_multiply_integerOverflow_2() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The product does not fit in an Integer variable");
        arithmeticOperations.multiply(2, Integer.MAX_VALUE);
    }
}
