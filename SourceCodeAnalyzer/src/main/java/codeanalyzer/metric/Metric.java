package codeanalyzer.metric;

import codeanalyzer.reader.SourceFileReader;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.io.IOException;


public abstract class Metric {
    protected String label;
    protected SourceFileReader fileReader;

	protected Metric(String label, SourceFileReader fileReader) {
		this.label = label;
		this.fileReader = fileReader;
	}

	public String getLabel() {
		return label;
	}

    public abstract int calculateWithRegex(String filepath) throws IOException;
    public abstract int calculateWithStringComparison(String filepath) throws IOException;

    public int regexCalculator(String sourceCode, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(sourceCode);

		int count = 0;
		while (matcher.find()) {
			count++;
		}
		return count;
	}

    public int strcompCalculator(List<String> sourceCodeList, Predicate<String> condition) {
		int count = 0;
		for (String line : sourceCodeList) {
			line = line.strip();
			if (condition.test(line)) {
				count++;
			}
		}
		return count;
	}
}
