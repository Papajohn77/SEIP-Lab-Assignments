package codeanalyzer.exporter;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;


public class CSVMetricsExporterTest {
    private CSVMetricsExporter csvMetricsExporter;

    @Before
    public void setUp() {
        csvMetricsExporter = new CSVMetricsExporter();
    }

    @Test
	public void test_writeFile() throws IOException {
        String outputFilepath = "src/test/resources/output_metrics";

		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("LOC", 30);
		metrics.put("NOM", 5);
		metrics.put("NOC", 2);

		csvMetricsExporter.writeFile(metrics, outputFilepath);

		File outputFile = new File(outputFilepath.concat(".csv"));

        String labelsLine;
        String metricsLine;
        try (BufferedReader bf = new BufferedReader(new FileReader(outputFile))) {
            labelsLine = bf.readLine();
            metricsLine = bf.readLine();
        }

        Assert.assertEquals(labelsLine, "LOC,NOC,NOM,");
        Assert.assertEquals(metricsLine, "30,2,5,");

		outputFile.delete();
	}
}
