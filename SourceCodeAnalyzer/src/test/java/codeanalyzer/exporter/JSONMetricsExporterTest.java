package codeanalyzer.exporter;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;


public class JSONMetricsExporterTest {
    private JSONMetricsExporter jsonMetricsExporter;

    @Before
    public void setUp() {
        jsonMetricsExporter = new JSONMetricsExporter(new Gson());
    }

    @Test
	public void test_writeFile() throws IOException {
        String outputFilepath = "src/test/resources/output_metrics";

		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("LOC", 77);
		metrics.put("NOM", 5);
		metrics.put("NOC", 7);

		jsonMetricsExporter.writeFile(metrics, outputFilepath);

		File outputFile = new File(outputFilepath.concat(".json"));

        String results;
        try (BufferedReader bf = new BufferedReader(new FileReader(outputFile))) {
            results = bf.readLine();
        }

        Assert.assertEquals(results, "{\"LOC\":77,\"NOC\":7,\"NOM\":5}");

		outputFile.delete();
	}
}
