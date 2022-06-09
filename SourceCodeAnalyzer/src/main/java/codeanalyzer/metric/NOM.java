package codeanalyzer.metric;

import codeanalyzer.reader.SourceFileReader;

import java.util.List;
import java.util.function.Predicate;

import java.io.IOException;


public class NOM extends Metric {

    public NOM(String label, SourceFileReader fileReader) {
        super(label, fileReader);
    }

    public int calculateWithRegex(String filepath) throws IOException {
		String sourceCode = fileReader.readFileIntoString(filepath);
		return regexCalculator(
			sourceCode, 
			".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*");
	}

    public int calculateWithStringComparison(String filepath) throws IOException {
        List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
        Predicate<String> condition
            = line -> ((line.contains("public") || line.contains("private")
                        || line.contains("protected")) || line.contains("void")
                        || line.contains("int") || line.contains("String"))
                      && line.contains("(")
                      && line.contains(")")
                      && line.contains("{");
        return strcompCalculator(sourceCodeList, condition);
	}
}
