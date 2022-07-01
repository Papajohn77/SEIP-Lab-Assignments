package codeanalyzer.calculator;

import codeanalyzer.metric.Metric;

import java.io.IOException;


public class RegexCalculator extends Calculator {

    public RegexCalculator(Metric metric) {
        super(metric);
    }

    public int calculate(String filepath) throws IOException {
        return metric.calculateWithRegex(filepath);
    }
}
