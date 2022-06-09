package codeanalyzer.exporter;

import java.util.Map;

import java.io.IOException;


public interface MetricsExporter {
	public void writeFile(Map<String, Integer> metrics, String filepath) throws IOException;
}
