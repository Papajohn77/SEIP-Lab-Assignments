package codeanalyzer.reader;

import java.util.List;

import java.net.URL;

import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;


public class WebSourceFileReader extends SourceFileReader {

    public List<String> readFileIntoList(String filepath) throws IOException {
        Reader reader = new InputStreamReader(new URL(filepath).openStream());
        return readFileList(reader);
    }

    public String readFileIntoString(String filepath) throws IOException {
        Reader reader = new InputStreamReader(new URL(filepath).openStream());
        return readFileString(reader);
    }
}
