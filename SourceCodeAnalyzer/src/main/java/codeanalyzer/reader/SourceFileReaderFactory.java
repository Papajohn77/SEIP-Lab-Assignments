package codeanalyzer.reader;

public class SourceFileReaderFactory {
    public SourceFileReader createSourceFileReader(SourceFileLocation location) {
        return location.createSourceFileReader();
    }
}
