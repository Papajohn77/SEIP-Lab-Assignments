package codeanalyzer.metric;

import codeanalyzer.reader.SourceFileLocation;
import codeanalyzer.reader.SourceFileReader;
import codeanalyzer.reader.SourceFileReaderFactory;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.io.IOException;


public class NOCTest {
    public static String filepath = "src/test/resources/TestClass.java";
    private NOC noc;

    @Before
    public void setUp() {
        SourceFileReaderFactory fileReaderFactory = new SourceFileReaderFactory();
		SourceFileReader fileReader = fileReaderFactory.createSourceFileReader(
            SourceFileLocation.LOCAL);
        noc = new NOC("NOC", fileReader);
    }

    @Test
    public void test_getLabel() throws IOException {
        Assert.assertEquals(noc.getLabel(), "NOC");
    }

    @Test
    public void test_calculateWithRegex() throws IOException {
        Assert.assertEquals(noc.calculateWithRegex(filepath), 3);
    }

    @Test
    public void test_calculateWithStringComparison() throws IOException {
        Assert.assertEquals(noc.calculateWithStringComparison(filepath), 3);
    }
}
