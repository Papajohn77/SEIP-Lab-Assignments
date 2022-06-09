package codeanalyzer;

import codeanalyzer.analyzer.AnalyzingMethod;
import codeanalyzer.analyzer.SourceCodeAnalyzer;
import codeanalyzer.analyzer.SourceCodeAnalyzerFactory;
import codeanalyzer.exporter.FileType;
import codeanalyzer.exporter.MetricsExporter;
import codeanalyzer.exporter.MetricsExporterFactory;
import codeanalyzer.reader.SourceFileReader;
import codeanalyzer.reader.SourceFileReaderFactory;
import codeanalyzer.reader.SourceFileLocation;

import java.util.Map;

import java.io.IOException;


public class Facade {

    public void exportSourceCodeMetrics(
        String filepath,
        String sourceCodeAnalyzerType,
        String sourceFileLocation,
        String outputFilePath,
        String outputFileType
    ) throws IOException {
        SourceFileReaderFactory fileReaderFactory = new SourceFileReaderFactory();
		SourceFileReader fileReader = fileReaderFactory.createSourceFileReader(
			SourceFileLocation.valueOf(sourceFileLocation.toUpperCase()));

		SourceCodeAnalyzerFactory analyzerFactory = new SourceCodeAnalyzerFactory();
		SourceCodeAnalyzer analyzer = analyzerFactory.createSourceCodeAnalyzer(
			AnalyzingMethod.valueOf(sourceCodeAnalyzerType.toUpperCase()),
			fileReader,
			filepath);
		Map<String, Integer> metrics = analyzer.calculateMetrics();
	
		MetricsExporterFactory exporterFactory = new MetricsExporterFactory();
		MetricsExporter exporter = exporterFactory.createMetricsExporter(
			FileType.valueOf(outputFileType.toUpperCase()));
		exporter.writeFile(metrics, outputFilePath);
    }
}
