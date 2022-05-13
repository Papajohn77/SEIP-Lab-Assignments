package math;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MyMathFactorialParameterizedTest {

    @Parameterized.Parameter (value = 0)
    public int inputNumber;

    @Parameterized.Parameter (value = 1)
    public int expectedResult;

    private MyMath myMath;

    @Before
    public void setUp() {
        myMath = new MyMath();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { 0, 1 },
            { 1, 1 },
            { 2, 2 },
            { 12, 479_001_600 }
        });
    }

    @Test
    public void test_factorial() {
        Assert.assertEquals(expectedResult, myMath.factorial(inputNumber));
    }
}
