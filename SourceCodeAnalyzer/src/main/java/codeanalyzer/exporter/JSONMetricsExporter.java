package codeanalyzer.exporter;

import com.google.gson.Gson;

import java.util.Map;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class JSONMetricsExporter implements MetricsExporter {
    private Gson gson;

    public JSONMetricsExporter(Gson gson) {
        this.gson = gson;
    }

    public void writeFile(Map<String, Integer> metrics, String filepath) throws IOException {
        File outputFile = new File(filepath.concat(".json"));

        try (FileWriter writer = new FileWriter(outputFile)) {
			writer.append(gson.toJson(metrics));
			System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
		}
	}
}
