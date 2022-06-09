package codeanalyzer.analyzer;

import codeanalyzer.calculator.Calculator;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.IOException;


public class SourceCodeAnalyzer {
    private String filepath;
    private List<Calculator> calculators;

    public SourceCodeAnalyzer(String filepath) {
        this.filepath = filepath;
        resetCalculators();
    }

    public void resetCalculators() {
        calculators = new ArrayList<>();
    }

    public void addCalculator(Calculator calculator) {
        calculators.add(calculator);
    }

    public Map<String, Integer> calculateMetrics() throws IOException {
        Map<String, Integer> metrics = new HashMap<>();

        for (Calculator calculator : calculators) {
            metrics.put(calculator.getLabel(), calculator.calculate(filepath));
        }

        return metrics;
    }
}
