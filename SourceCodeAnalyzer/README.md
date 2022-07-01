# Source Code Analyzer

A Maven project that reads a Java source code file that is stored locally or on the web, calculates the Lines of Code (LOC), Number of Classes (NOC), and Number of Methods (NOM) metrics, and finally, exports these metrics to an output file.

<br>

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

<br>

## Design Patterns

### Initial Design

![](https://mermaid.ink/img/pako:eNp9UtFOwyAU_RVCfNji2g_og4npZqLpNNkerQ8E7iqRwnKh6ly6bxfKbOtsfCGXcw73HC4cKTcCaEa5YtYuJauQ1aUmREgE7qTRpNiEfceTJdQmVxK0I8eAEnJdM6lnW4dSV88vhGFl51eBasMy0ifJDdmaBjnk3vFWM3X4ApwQrcE343b1uTfooiKax9N3UsEGmADsI6DfBvheO1NI62Zpms5JqE4x2GlCGJkojXWfemw3DtsbcqZ4o5iD4imPHaR2l9zjv9z6F9fZThgOQxuuPSS8mFQf7wOl6w50HhFMOjC373-wB2t0D7Z0QWtA_6jCf4quYUndK9RQ0syXguFbSUsddM1e-KushHQGabZjysKCssaP9qA5zRw28CM6f6yzqv0GB4PR_A)

### Problems With the Initial Design

All three classes of the codeanalyzer package in the initial design have the same two main issues:

- Control Coupling (exists among two modules if data from one module is used to direct the structure of instruction execution in another)
- Code Duplication

Also, in the initial design we don't have any abstractions (for example the SourceCodeAnalyzer class depends on the concrete SourceFileReader - Dependency Inversion principle violation) & there is no way we can add anything (SourceFileReader, SourceCodeAnalyzer or MetricsExporter) without modifying existing code (Open/Closed principle violation).

Finally, the client needs to know about implementation details since it performs the "object wiring" to fulfill its task. Therefore, client is tightly coupled with most of the classes in the codeanalyzer package.

### Redesigned System

![](https://mermaid.ink/img/pako:eNrNV21v2jAQ_itWtg_QkvyACiF1Ka02QZmgWieNfXATA9HyghyjlbXw23eOHTsxdlrtRduX1jGPn3vufHe5PHlRERPvwotSXJZXCV5TnC1zhKpndEWyIkwTkjP0xHcROs9wkvcWjCb5-stXhOm67L_lPx34nwbe90foGkc4JppOPCsq8rgtKFsUOxqREGRMCdBGZS8Igr6ilGc4nUBeJymZE9ij8BMr6P4FlPVnbu4yx-n-RzdNE2cApNpx5YSLxQDpUJgq66AMh_ihZBTIRiMZJgoADnyfs0IEXsYfrWB3i9mmf2aBTpKSvQiUfFIDrf71DUxFdIo4aGcmRYRTl0ev0f9a-cruibHhs-_bdWiZ9-ThPxBpUWFLC-4LS4pcJwbJdxmh1WadG5NZeDkRy_vxOykwAoWMmDZ64u4NYcpKEIzc4XPgX-lJq1hVwB0qLaZSuXAHtuZul39NoDWJanSX2ht5lSl-IGm9ZV7iquUseLImbMIP9OoMgShGuxS8u0_YZk7W5NFZhy2oAIVFtsU0KYu8o3qBM5RHC1rjStWyBkhuVchaFzgbAXnjYKvTnnjq-2cyZI1Sn4X6Cl_285fcVIrkfYnanoVaxe2_UnHbVjH9VyqmZlKrV4zO7iSHxxWOSJ3e32nCqvvtTfH2KCwNEPQxkEuPKBNEKndONQiD4eKTw-b5b1swiYfPQWAxqMV8WMxuHWr8GwgoWpeiA_w1dRYFjYkHOO72W9LZxcE_seBUrfZo8DZ7uGLmndgeoRakU6Z9ljF6tSlG0a_kwhmoZn-uTzXySfWjjs4s0z9T7aiz8do7Z7OOeG_ThrWYebu1nta3u0Ibp6oqNagar0aj6P-MOTer-VJuDrWqWAw7cpcPOEfNdESRWpem1Hp8N98oLXNnoNSmTABAAbBsirizXubjm_FnsVzczcPZ9KNlpmhard5zOgVMW7w87OO-K2pdw8yJ4Y5w2AcXc_BynTD8WObewINYwRdaDF90lbalxzYkI0vvApYxpt-W3jI_AG63jUHxOE6AzbtY4bQkAw_vYPjd55HaECj5WSh3Dz8BZyftWA)

### Design Patterns Decisions

#### [Façade Pattern](https://refactoring.guru/design-patterns/facade)

Since one of the requirements was to use the system as an independent library & hide any implementation details from the DemoClient, the Façade Pattern was applied to provide a limited but straightforward interface to the clients of the codeanalyzer package. The Façade provides a shortcut to export the metrics (LOC, NOC, NOM) of a single Java source code file stored in a specified location (locally or on the web) in the prefered format (CSV or JSON), however codeanalyzer classes are still available for direct use by clients that want to perform more complex tasks.

Package [codeanalyzer](./src/main/java/codeanalyzer/)

- Facade -> [Facade.java](./src/main/java/codeanalyzer/Facade.java)

<br>

#### [Strategy Pattern](https://refactoring.guru/design-patterns/strategy)

The Strategy Pattern\* was chosen for the redesign of the MetricsExporter & SourceFileReader classes since their methods were executing different variants of the same algorithm based on a conditional statement (Control Coupling), which can be achieved by applying the Strategy Pattern, through polymorphism. The advantage of this approach is that we can easily introduce new types of MetricsExporters & SourceFileReader without having to modify any of the existing code.

\*One of the main properties of the original Strategy Pattern is that it allow us to swap the algorithms used inside an object at runtime as it uses composition. However, in this particular example there was no reason to add a Context class (needless complexity) since only a more complex client would be capable of utilizing this feature (not within the scope of this assignment).

Package [exporter](./src/main/java/codeanalyzer/exporter/)

- Strategy -> [MetricsExporter.java](./src/main/java/codeanalyzer/exporter/MetricsExporter.java)
- ConcreteStrategy_1 -> [CSVMetricsExporter.java](./src/main/java/codeanalyzer/exporter/CSVMetricsExporter.java)
- ConcreteStrategy_2 -> [JSONMetricsExporter.java](./src/main/java/codeanalyzer/exporter/JSONMetricsExporter.java)

<br>

Package [reader](./src/main/java/codeanalyzer/reader/)

- Strategy -> [SourceFileReader.java](./src/main/java/codeanalyzer/reader/SourceFileReader.java)
- ConcreteStrategy_1 -> [CSVMetricsExporter.java](./src/main/java/codeanalyzer/exporter/CSVMetricsExporter.java)
- ConcreteStrategy_2 -> [JSONMetricsExporter.java](./src/main/java/codeanalyzer/exporter/JSONMetricsExporter.java)

<br>

#### [Simple Factory Pattern](https://refactoring.guru/design-patterns/factory-comparison)

The Simple Factory was chosen since it goes well with the Strategy Pattern, as it allow us to decouple our client ([Facade](./src/main/java/codeanalyzer/Facade.java) in our case) by separating the instantiation process into a separate class. I chose to implement the Simple Factory using enums because i think it is a cleaner implementation.

Package [exporter](./src/main/java/codeanalyzer/exporter/)

- Factory -> [MetricsExporterFactory.java](./src/main/java/codeanalyzer/exporter/MetricsExporterFactory.java)
- Enum -> [FileType.java](./src/main/java/codeanalyzer/exporter/FileType.java)

<br>

Package [reader](./src/main/java/codeanalyzer/reader/)

- Factory -> [SourceFileReaderFactory.java](./src/main/java/codeanalyzer/reader/SourceFileReaderFactory.java)
- Enum -> [SourceFileLocation.java](./src/main/java/codeanalyzer/reader/SourceFileLocation.java)

<br>

Package [analyzer](./src/main/java/codeanalyzer/analyzer/)

- Factory -> [SourceCodeAnalyzerFactory.java](./src/main/java/codeanalyzer/analyzer/SourceCodeAnalyzerFactory.java)
- Enum -> [AnalyzingMethod.java](./src/main/java/codeanalyzer/analyzer/AnalyzingMethod.java)

<br>

#### [Bridge Pattern](https://refactoring.guru/design-patterns/bridge)

The Bridge Pattern was chosen for the redesign of the SourceCodeAnalyzer class to split it into two separate class hierarchies ([Calculators](./src/main/java/codeanalyzer/calculator/) & [Metrics](./src/main/java/codeanalyzer/metric/)) which can be developed independently of each other. Also, although not useful in this particular example, a more complex client would be able to assemble different kinds of SourceCodeAnalyzers by combining the different types of calculators. Finally, i want to mention that i realized that the application of the Bridge Pattern in this example was an overkill (needless complexity) and particularly because as we seen in the last Lab session the types of metrics that can be added are very limited and i think the same applies for the Calculator types as well.

Package [analyzer](./src/main/java/codeanalyzer/analyzer/)

- Client -> [SourceCodeAnalyzer.java](./src/main/java/codeanalyzer/analyzer/SourceCodeAnalyzer.java)

<br>

Package [calculator](./src/main/java/codeanalyzer/calculator/)

- Abstraction -> [Calculator.java](./src/main/java/codeanalyzer/calculator/Calculator.java)
- RefinedAbstraction_1 -> [RegexCalculator.java](./src/main/java/codeanalyzer/calculator/RegexCalculator.java)
- RefinedAbstraction_2 -> [StringComparisonCalculator.java](./src/main/java/codeanalyzer/calculator/StringComparisonCalculator.java)

<br>

Package [metric](./src/main/java/codeanalyzer/metric/)

- Implementation -> [Metric](./src/main/java/codeanalyzer/metric/Metric.java)
- ConcreteImplementation_1 -> [LOC.java](./src/main/java/codeanalyzer/metric/LOC.java)
- ConcreteImplementation_2 -> [NOC.java](./src/main/java/codeanalyzer/metric/NOC.java)
- ConcreteImplementation_3 -> [NOM.java](./src/main/java/codeanalyzer/metric/NOM.java)

### Disclaimers

- Comments were removed because most of them were redundant. However, in some situations (such as to explain the regular expressions) some comments could be added.

- There is no error handling implemented to handle cases where the client provides wrong arguments. However, in those cases it would be a lot better to ask the user to provide us with a valid argument value (or at least have user-friendly error messages).

## Author

- Ioannis Papadatos
