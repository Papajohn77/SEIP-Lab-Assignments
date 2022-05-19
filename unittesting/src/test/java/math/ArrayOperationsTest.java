package math;

import io.FileIO;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrayOperationsTest {
    private ArrayOperations arrayOperations;

    @Before
    public void setUp() {
        arrayOperations = new ArrayOperations();
    }

    @Test
    public void test_findPrimesInFile() {
        FileIO fileIO = mock(FileIO.class);
        MyMath myMath = mock(MyMath.class);

        when(fileIO.readFile(null)).thenReturn(new int[]{
            7, 2, 9, 0, 7, 2, 9
        });

        when(myMath.isPrime(7)).thenReturn(true);
        when(myMath.isPrime(2)).thenReturn(true);
        when(myMath.isPrime(9)).thenReturn(false);
        when(myMath.isPrime(0)).thenThrow(IllegalArgumentException.class);

        Assert.assertArrayEquals(
            new int[]{7, 2, 7, 2},
            arrayOperations.findPrimesInFile(null, fileIO, myMath));
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_findPrimesInFile_IllegalArgumentException() {
        FileIO fileIO = mock(FileIO.class);
        when(fileIO.readFile(null)).thenThrow(IllegalArgumentException.class);

        arrayOperations.findPrimesInFile(null, fileIO, null);
    }
}
