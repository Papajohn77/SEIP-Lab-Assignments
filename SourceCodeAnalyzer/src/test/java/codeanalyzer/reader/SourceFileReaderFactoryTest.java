package codeanalyzer.reader;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;


public class SourceFileReaderFactoryTest {
    private SourceFileReaderFactory fileReaderFactory;

    @Before
    public void setUp() {
        fileReaderFactory = new SourceFileReaderFactory();
    }

    @Test
    public void test_createMetricsExporter_local() {
        SourceFileReader exporter = fileReaderFactory.createSourceFileReader(
            SourceFileLocation.LOCAL);
        Assert.assertTrue(exporter instanceof LocalSourceFileReader);
    }

    @Test
    public void test_createMetricsExporter_web() {
        SourceFileReader exporter = fileReaderFactory.createSourceFileReader(
            SourceFileLocation.WEB);
        Assert.assertTrue(exporter instanceof WebSourceFileReader);
    }
}
