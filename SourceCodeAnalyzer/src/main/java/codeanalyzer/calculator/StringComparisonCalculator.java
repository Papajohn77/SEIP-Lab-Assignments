package codeanalyzer.calculator;

import codeanalyzer.metric.Metric;

import java.io.IOException;


public class StringComparisonCalculator extends Calculator {

    public StringComparisonCalculator(Metric metric) {
        super(metric);
    }

    public int calculate(String filepath) throws IOException {
        return metric.calculateWithStringComparison(filepath);
    }
}
