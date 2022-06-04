package io;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class FileIOTest {
    public static String resourcePath = "src/test/resources/";
    private FileIO fileIO;

    @Before
    public void setUp() {
        fileIO = new FileIO();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_readFile_validNumbers() {
        String filepath = resourcePath.concat("numbers_valid.txt");
        int[] expectedNumbers = new int[] {
            7, 7, 2, 2, 9, 9, -7, -7, 0
        };
    
        Assert.assertArrayEquals(expectedNumbers, fileIO.readFile(filepath));
    }

    @Test
    public void test_readFile_invalidNumbers() {
        String filepath = resourcePath.concat("numbers_invalid.txt");
        int[] expectedNumbers = new int[] {
            7, 2, 9, 7, 2, 9
        };
    
        Assert.assertArrayEquals(expectedNumbers, fileIO.readFile(filepath));
    }

    @Test
    public void test_readFile_emptyFile() {
        String filepath = resourcePath.concat("empty.txt");
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Input file is empty");
    
        fileIO.readFile(filepath);
    }

    @Test
    public void test_readFile_fileNotExist() {
        String filepath = resourcePath.concat("not_exist.txt");
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Input file does not exist");
    
        fileIO.readFile(filepath);
    }
}
