package codeanalyzer.analyzer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import codeanalyzer.calculator.Calculator;
import codeanalyzer.calculator.RegexCalculator;
import codeanalyzer.calculator.StringComparisonCalculator;

import java.util.Map;
import java.io.IOException;

import org.junit.Test;
import org.junit.Assert;


public class SourceCodeAnalyzerTest {

    @Test
    public void test_calculateMetrics_regex() throws IOException {
        Calculator regexCalc = mock(RegexCalculator.class);

        when(regexCalc.getLabel())
            .thenReturn("LOC")
            .thenReturn("NOM")
            .thenReturn("NOC");

        when(regexCalc.calculate(null))
            .thenReturn(21)
            .thenReturn(7)
            .thenReturn(7);

        SourceCodeAnalyzer analyzer = new SourceCodeAnalyzer(null);
        analyzer.addCalculator(regexCalc);
        analyzer.addCalculator(regexCalc);
        analyzer.addCalculator(regexCalc);
        Map<String, Integer> metrics = analyzer.calculateMetrics();

        int loc = metrics.get("LOC");
        Assert.assertEquals(loc, 21);

        int nom = metrics.get("NOM");
        Assert.assertEquals(nom, 7);

        int noc = metrics.get("NOC");
        Assert.assertEquals(noc, 7);
    }

    @Test
    public void test_calculateMetrics_strcomp() throws IOException {
        Calculator strcompCalc = mock(StringComparisonCalculator.class);

        when(strcompCalc.getLabel())
            .thenReturn("LOC")
            .thenReturn("NOM")
            .thenReturn("NOC");

        when(strcompCalc.calculate(null))
            .thenReturn(15)
            .thenReturn(7)
            .thenReturn(7);

        SourceCodeAnalyzer analyzer = new SourceCodeAnalyzer(null);
        analyzer.addCalculator(strcompCalc);
        analyzer.addCalculator(strcompCalc);
        analyzer.addCalculator(strcompCalc);
        Map<String, Integer> metrics = analyzer.calculateMetrics();

        int loc = metrics.get("LOC");
        Assert.assertEquals(loc, 15);

        int nom = metrics.get("NOM");
        Assert.assertEquals(nom, 7);

        int noc = metrics.get("NOC");
        Assert.assertEquals(noc, 7);
    }
}
