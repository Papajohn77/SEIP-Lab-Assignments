package codeanalyzer.metric;

import codeanalyzer.reader.SourceFileLocation;
import codeanalyzer.reader.SourceFileReader;
import codeanalyzer.reader.SourceFileReaderFactory;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.io.IOException;


public class NOMTest {
    public static String filepath = "src/test/resources/TestClass.java";
    private NOM nom;

    @Before
    public void setUp() {
        SourceFileReaderFactory fileReaderFactory = new SourceFileReaderFactory();
		SourceFileReader fileReader = fileReaderFactory.createSourceFileReader(
            SourceFileLocation.LOCAL);
        nom = new NOM("NOM", fileReader);
    }

    @Test
    public void test_getLabel() throws IOException {
        Assert.assertEquals(nom.getLabel(), "NOM");
    }

    @Test
    public void test_calculateWithRegex() throws IOException {
        Assert.assertEquals(nom.calculateWithRegex(filepath), 3);
    }

    @Test
    public void test_calculateWithStringComparison() throws IOException {
        Assert.assertEquals(nom.calculateWithStringComparison(filepath), 3);
    }
}
