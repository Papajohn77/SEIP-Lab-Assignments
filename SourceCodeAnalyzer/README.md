# Source Code Analyzer

A simple Maven project that reads a Java source code file that is stored locally or on the web, calculates the Lines of Code (LOC), Number of Classes (NOC), and Number of Methods (NOM) metrics, and finally, exports these metrics to an output file.

## Getting Started

### Prerequisites

- [Java](https://www.oracle.com/java/technologies/downloads)
- [Maven](https://maven.apache.org)

### Installing

- #### Clone

  `git clone https://github.com/Papajohn77/SEIP-Lab-Assignments.git`

- #### Change Directory

  `cd SEIP-Lab-Assignments`

- #### Build

  `mvn clean package`

- #### Execute

  `java -jar SourceCodeAnalyzer/target/SourceCodeAnalyzer-jar-with-dependencies.jar arg0 arg1 arg2 arg3 arg4`

  - arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
  - arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
  - arg2 = “SourceCodeLocationType” [local|web]
  - arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
  - arg4 = “OutputFileType” [csv|json]

## Author

- Ioannis Papadatos
