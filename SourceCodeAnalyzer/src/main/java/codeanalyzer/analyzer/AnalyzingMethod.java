package codeanalyzer.analyzer;

import codeanalyzer.metric.LOC;
import codeanalyzer.metric.NOC;
import codeanalyzer.metric.NOM;
import codeanalyzer.reader.SourceFileReader;

import codeanalyzer.calculator.RegexCalculator;
import codeanalyzer.calculator.StringComparisonCalculator;


public enum AnalyzingMethod {
    REGEX {
        @Override
        public SourceCodeAnalyzer createSourceCodeAnalyzer(
                SourceFileReader fileReader, String filepath) {
            SourceCodeAnalyzer analyzer = new SourceCodeAnalyzer(filepath);
            analyzer.addCalculator(new RegexCalculator(new LOC("LOC", fileReader)));
            analyzer.addCalculator(new RegexCalculator(new NOM("NOM", fileReader)));
            analyzer.addCalculator(new RegexCalculator(new NOC("NOC", fileReader)));
            return analyzer;
        }
    },
    STRCOMP {
        @Override
        public SourceCodeAnalyzer createSourceCodeAnalyzer(
                SourceFileReader fileReader, String filepath) {
            SourceCodeAnalyzer analyzer = new SourceCodeAnalyzer(filepath);
            analyzer.addCalculator(
                new StringComparisonCalculator(new LOC("LOC", fileReader)));
            analyzer.addCalculator(
                new StringComparisonCalculator(new NOM("NOM", fileReader)));
            analyzer.addCalculator(
                new StringComparisonCalculator(new NOC("NOC", fileReader)));
            return analyzer;
        }
    };

    public abstract SourceCodeAnalyzer createSourceCodeAnalyzer(
        SourceFileReader fileReader, String filepath);
}
