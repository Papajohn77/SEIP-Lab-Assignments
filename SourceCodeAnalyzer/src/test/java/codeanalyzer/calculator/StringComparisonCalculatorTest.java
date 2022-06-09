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


public class StringComparisonCalculatorTest {

    @Test
    public void test_getLabel_LOC() throws IOException {
        Metric loc = mock(LOC.class);
        when(loc.getLabel()).thenReturn("LOC");
        StringComparisonCalculator strcompCalculatorLOC = new StringComparisonCalculator(loc);

        Assert.assertEquals(strcompCalculatorLOC.getLabel(), "LOC");
    }

    @Test
    public void test_getLabel_NOM() throws IOException {
        Metric nom = mock(NOM.class);
        when(nom.getLabel()).thenReturn("NOM");
        StringComparisonCalculator strcompCalculatorNOM = new StringComparisonCalculator(nom);

        Assert.assertEquals(strcompCalculatorNOM.getLabel(), "NOM");
    }

    @Test
    public void test_getLabel_NOC() throws IOException {
        Metric noc = mock(NOC.class);
        when(noc.getLabel()).thenReturn("NOC");
        StringComparisonCalculator strcompCalculatorNOC = new StringComparisonCalculator(noc);

        Assert.assertEquals(strcompCalculatorNOC.getLabel(), "NOC");
    }

    @Test
    public void test_calculate_LOC() throws IOException {
        Metric loc = mock(LOC.class);
        when(loc.calculateWithStringComparison(null)).thenReturn(7);
        StringComparisonCalculator strcompCalculatorLOC = new StringComparisonCalculator(loc);

        Assert.assertEquals(strcompCalculatorLOC.calculate(null), 7);
    }

    @Test
    public void test_calculate_NOM() throws IOException {
        Metric nom = mock(NOM.class);
        when(nom.calculateWithStringComparison(null)).thenReturn(6);
        StringComparisonCalculator strcompCalculatorNOM = new StringComparisonCalculator(nom);

        Assert.assertEquals(strcompCalculatorNOM.calculate(null), 6);
    }

    @Test
    public void test_calculate_NOC() throws IOException {
        Metric noc = mock(NOC.class);
        when(noc.calculateWithStringComparison(null)).thenReturn(1);
        StringComparisonCalculator strcompCalculatorNOC = new StringComparisonCalculator(noc);

        Assert.assertEquals(strcompCalculatorNOC.calculate(null), 1);
    }
}
