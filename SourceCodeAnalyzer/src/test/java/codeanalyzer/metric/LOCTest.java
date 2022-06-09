package codeanalyzer.metric;

import codeanalyzer.reader.SourceFileLocation;
import codeanalyzer.reader.SourceFileReader;
import codeanalyzer.reader.SourceFileReaderFactory;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.io.IOException;


public class LOCTest {
    public static String filepath = "src/test/resources/TestClass.java";
    private LOC loc;

    @Before
    public void setUp() {
        SourceFileReaderFactory fileReaderFactory = new SourceFileReaderFactory();
		SourceFileReader fileReader = fileReaderFactory.createSourceFileReader(
            SourceFileLocation.LOCAL);
        loc = new LOC("LOC", fileReader);
    }

    @Test
    public void test_getLabel() throws IOException {
        Assert.assertEquals(loc.getLabel(), "LOC");
    }

    @Test
    public void test_calculateWithRegex() throws IOException {
        Assert.assertEquals(loc.calculateWithRegex(filepath), 21);
    }

    @Test
    public void test_calculateWithStringComparison() throws IOException {
        Assert.assertEquals(loc.calculateWithStringComparison(filepath), 7);
    }
}
