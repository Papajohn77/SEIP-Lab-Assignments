package codeanalyzer.metric;

import codeanalyzer.reader.SourceFileReader;

import java.util.List;
import java.util.function.Predicate;

import java.io.IOException;


public class LOC extends Metric {

    public LOC(String label, SourceFileReader fileReader) {
        super(label, fileReader);
    }

    public int calculateWithRegex(String filepath) throws IOException {
		String sourceCode = fileReader.readFileIntoString(filepath);
		int sourceFileLength = sourceCode.split("\n").length;
		int nonCodeLines = regexCalculator(sourceCode, "((//.*)|(/\\*.*)|(\\*+.*))");
		
		return sourceFileLength - nonCodeLines;
	}

    public int calculateWithStringComparison(String filepath) throws IOException {
        List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
        Predicate<String> condition = line -> line.startsWith("//")
            || line.startsWith("/*")
            || line.startsWith("*")
            || line.equals("{")
            || line.equals("}")
            || line.equals("");
        int nonCodeLines = strcompCalculator(sourceCodeList, condition);

        return sourceCodeList.size() - nonCodeLines;
	}
}
