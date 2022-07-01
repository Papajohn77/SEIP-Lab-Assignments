package codeanalyzer.reader;

import java.util.List;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.io.IOException;


public class LocalSourceFileReader extends SourceFileReader {

	public List<String> readFileIntoList(String filepath) throws IOException {
		Reader reader = new FileReader(new File(filepath));
		return readFileList(reader);
	}

	public String readFileIntoString(String filepath) throws IOException {
		Reader reader = new FileReader(new File(filepath));
		return readFileString(reader);
	}
}
