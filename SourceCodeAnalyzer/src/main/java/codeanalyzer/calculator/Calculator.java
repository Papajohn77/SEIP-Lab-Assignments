package codeanalyzer.calculator;

import codeanalyzer.metric.Metric;

import java.io.IOException;


public abstract class Calculator {
    protected Metric metric;

    protected Calculator(Metric metric) {
        this.metric = metric;
    }

    public String getLabel() {
        return metric.getLabel();
    }

    public abstract int calculate(String filepath) throws IOException;
}
