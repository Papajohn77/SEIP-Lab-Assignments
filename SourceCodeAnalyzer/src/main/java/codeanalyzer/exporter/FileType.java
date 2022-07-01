package codeanalyzer.exporter;

import com.google.gson.Gson;


public enum FileType {
    CSV {
        @Override
        public MetricsExporter createMetricsExporter() {
            return new CSVMetricsExporter();
        }
    },
    JSON {
        @Override
        public MetricsExporter createMetricsExporter() {
            return new JSONMetricsExporter(new Gson());
        }
    };

    public abstract MetricsExporter createMetricsExporter();
}
