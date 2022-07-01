package codeanalyzer.metric;

import codeanalyzer.reader.SourceFileReader;

import java.util.List;
import java.util.function.Predicate;

import java.io.IOException;


public class NOC extends Metric {

    public NOC(String label, SourceFileReader fileReader) {
        super(label, fileReader);
    }

    public int calculateWithRegex(String filepath) throws IOException {
		String sourceCode = fileReader.readFileIntoString(filepath);
		return regexCalculator(sourceCode, ".*\\s*class\\s+.*");
	}

    public int calculateWithStringComparison(String filepath) throws IOException {
        List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
        Predicate<String> condition
            = line -> (line.startsWith("class ") || line.contains(" class "))
                      && line.contains("{");
        return strcompCalculator(sourceCodeList, condition);
	}
}
