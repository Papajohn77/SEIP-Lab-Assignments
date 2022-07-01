package codeanalyzer.reader;

public enum SourceFileLocation {
    LOCAL {
        @Override
        public SourceFileReader createSourceFileReader() {
            return new LocalSourceFileReader();
        }
    },
    WEB {
        @Override
        public SourceFileReader createSourceFileReader() {
            return new WebSourceFileReader();
        }
    };

    public abstract SourceFileReader createSourceFileReader();
}
