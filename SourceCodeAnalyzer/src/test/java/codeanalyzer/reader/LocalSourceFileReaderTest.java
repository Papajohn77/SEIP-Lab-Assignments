package codeanalyzer.reader;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.util.List;

import java.io.File;
import java.io.IOException;

import java.nio.charset.Charset;
import java.nio.file.Files;



public class LocalSourceFileReaderTest {
    public static String filepath = "src/test/resources/TestClass.java";
    private LocalSourceFileReader localSourceFileReader;
	private List<String> expectedList;
	private String expectedString;
	
	@Before
	public void setUp() throws IOException {
		expectedList = Files.readAllLines(
            new File(filepath).toPath(), Charset.defaultCharset());
		expectedString = String.join("\n", expectedList) + "\n";
		localSourceFileReader = new LocalSourceFileReader();
	}
	
	@Test
	public void test_readFileIntoList() throws IOException {
		List<String> actualList = localSourceFileReader.readFileIntoList(filepath);
		
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);
		
		Assert.assertArrayEquals(expecteds, actuals);
	}

    @Test
	public void test_eeadFileIntoString() throws IOException {
		String actuals = localSourceFileReader.readFileIntoString(filepath);

		Assert.assertEquals(expectedString, actuals);
	}
}
