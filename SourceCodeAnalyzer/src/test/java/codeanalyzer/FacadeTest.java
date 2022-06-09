package codeanalyzer;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FacadeTest {
    public static String resourcePath = "src/test/resources/";
    private Facade facade;

    @Before
    public void setUp() throws IOException {
        facade = new Facade();
    }

    @Test
    public void test_exportSourceCodeMetrics_regex_csv() throws IOException {
        String filepath = resourcePath.concat("TestClass.java");
        String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
        String outputFilePath = resourcePath.concat("output_metrics");
        String outputFileType = "csv";

        facade.exportSourceCodeMetrics(
            filepath,
            sourceCodeAnalyzerType,
            sourceFileLocation,
            outputFilePath,
            outputFileType);

        File outputFile = new File(outputFilePath.concat(".csv"));

        String labelsLine;
        String metricsLine;
        try (BufferedReader bf = new BufferedReader(new FileReader(outputFile))) {
            labelsLine = bf.readLine();
            metricsLine = bf.readLine();
        }

        Assert.assertEquals(labelsLine, "LOC,NOC,NOM,");
        Assert.assertEquals(metricsLine, "21,3,3,");

		outputFile.delete();
    }

    @Test
    public void test_exportSourceCodeMetrics_strcomp_json() throws IOException {
        String filepath = resourcePath.concat("TestClass.java");
        String sourceCodeAnalyzerType = "strcomp";
		String sourceFileLocation = "local";
        String outputFilePath = resourcePath.concat("output_metrics");
        String outputFileType = "json";

        facade.exportSourceCodeMetrics(
            filepath,
            sourceCodeAnalyzerType,
            sourceFileLocation,
            outputFilePath,
            outputFileType);

        File outputFile = new File(outputFilePath.concat(".json"));

        String results;
        try (BufferedReader bf = new BufferedReader(new FileReader(outputFile))) {
            results = bf.readLine();
        }

        Assert.assertEquals(results, "{\"LOC\":7,\"NOC\":3,\"NOM\":3}");

		outputFile.delete();
    }
}
