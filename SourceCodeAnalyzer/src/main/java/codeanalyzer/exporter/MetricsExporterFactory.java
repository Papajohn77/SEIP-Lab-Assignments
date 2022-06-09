package codeanalyzer.exporter;

public class MetricsExporterFactory {
    public MetricsExporter createMetricsExporter(FileType fileType) {
        return fileType.createMetricsExporter();
    }
}
