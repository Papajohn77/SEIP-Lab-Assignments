package codeanalyzer.exporter;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;


public class MetricsExporterFactoryTest {
    private MetricsExporterFactory exporterFactory;

    @Before
    public void setUp() {
        exporterFactory = new MetricsExporterFactory();
    }

    @Test
    public void test_createMetricsExporter_CSV() {
        MetricsExporter exporter = exporterFactory.createMetricsExporter(FileType.CSV);
        Assert.assertTrue(exporter instanceof CSVMetricsExporter);
    }

    @Test
    public void test_createMetricsExporter_JSON() {
        MetricsExporter exporter = exporterFactory.createMetricsExporter(FileType.JSON);
        Assert.assertTrue(exporter instanceof JSONMetricsExporter);
    }
}
