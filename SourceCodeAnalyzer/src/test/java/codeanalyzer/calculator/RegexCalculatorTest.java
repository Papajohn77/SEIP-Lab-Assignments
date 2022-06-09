package codeanalyzer.calculator;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import codeanalyzer.metric.LOC;
import codeanalyzer.metric.NOC;
import codeanalyzer.metric.NOM;
import codeanalyzer.metric.Metric;

import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;


public class RegexCalculatorTest {

    @Test
    public void test_getLabel_LOC() throws IOException {
        Metric loc = mock(LOC.class);
        when(loc.getLabel()).thenReturn("LOC");
        RegexCalculator regexCalculatorLOC = new RegexCalculator(loc);

        Assert.assertEquals(regexCalculatorLOC.getLabel(), "LOC");
    }

    @Test
    public void test_getLabel_NOM() throws IOException {
        Metric nom = mock(NOM.class);
        when(nom.getLabel()).thenReturn("NOM");
        RegexCalculator regexCalculatorNOM = new RegexCalculator(nom);

        Assert.assertEquals(regexCalculatorNOM.getLabel(), "NOM");
    }

    @Test
    public void test_getLabel_NOC() throws IOException {
        Metric noc = mock(NOC.class);
        when(noc.getLabel()).thenReturn("NOC");
        RegexCalculator regexCalculatorNOC = new RegexCalculator(noc);

        Assert.assertEquals(regexCalculatorNOC.getLabel(), "NOC");
    }

    @Test
    public void test_calculate_LOC() throws IOException {
        Metric loc = mock(LOC.class);
        when(loc.calculateWithRegex(null)).thenReturn(24);
        RegexCalculator regexCalculatorLOC = new RegexCalculator(loc);

        Assert.assertEquals(regexCalculatorLOC.calculate(null), 24);
    }

    @Test
    public void test_calculate_NOM() throws IOException {
        Metric nom = mock(NOM.class);
        when(nom.calculateWithRegex(null)).thenReturn(5);
        RegexCalculator regexCalculatorNOM = new RegexCalculator(nom);

        Assert.assertEquals(regexCalculatorNOM.calculate(null), 5);
    }

    @Test
    public void test_calculate_NOC() throws IOException {
        Metric noc = mock(NOC.class);
        when(noc.calculateWithRegex(null)).thenReturn(3);
        RegexCalculator regexCalculatorNOC = new RegexCalculator(noc);

        Assert.assertEquals(regexCalculatorNOC.calculate(null), 3);
    }
}
