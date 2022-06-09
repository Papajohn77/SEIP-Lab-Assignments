package codeanalyzer.exporter;

import java.util.Map;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CSVMetricsExporter implements MetricsExporter {

    public void writeFile(Map<String, Integer> metrics, String filepath) throws IOException {
		File outputFile = new File(filepath.concat(".csv"));
		StringBuilder metricsNames = new StringBuilder();
		StringBuilder metricsValues = new StringBuilder();

		for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
			metricsNames.append(entry.getKey() + ",");
			metricsValues.append(entry.getValue() + ",");
		}

		try (FileWriter writer = new FileWriter(outputFile)) {
			writer.append(metricsNames + "\n");
			writer.append(metricsValues + "\n");
			System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
		}
	}
}
