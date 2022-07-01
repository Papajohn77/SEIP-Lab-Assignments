package codeanalyzer.reader;

import java.util.List;
import java.util.ArrayList;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;

public abstract class SourceFileReader {
    public abstract String readFileIntoString(String filepath) throws IOException;
    public abstract List<String> readFileIntoList(String filepath) throws IOException;

    public String readFileString(Reader reader) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader bf = new BufferedReader(reader)) {
			String line = null;
			while ((line = bf.readLine()) != null) {
				sb.append(line + "\n");
			}
		}
		return sb.toString();
	}

    public List<String> readFileList(Reader reader) throws IOException {
		List<String> lines = new ArrayList<>();
		try (BufferedReader bf = new BufferedReader(reader)) {
			String line = null;
			while ((line = bf.readLine()) != null) {
				lines.add(line);
			}
		}
		return lines;
	}
}
