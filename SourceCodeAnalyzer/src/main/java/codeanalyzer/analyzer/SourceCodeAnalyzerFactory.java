package codeanalyzer.analyzer;

import codeanalyzer.reader.SourceFileReader;


public class SourceCodeAnalyzerFactory {

    public SourceCodeAnalyzer createSourceCodeAnalyzer(AnalyzingMethod method,
            SourceFileReader fileReader, String filepath) {
        return method.createSourceCodeAnalyzer(fileReader, filepath);
    }
}
