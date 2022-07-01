package codeanalyzer.reader;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.util.List;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.charset.Charset;


public class WebSourceFileReaderTest {
    public static String filepath = "src/test/resources/TestClass.java";
    public static String url = "https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
    private WebSourceFileReader webSourceFileReader;
	private List<String> expectedList;
	private String expectedString;
	
	@Before
	public void setUp() throws IOException {
		expectedList = Files.readAllLines(
            new File(filepath).toPath(), Charset.defaultCharset());
		expectedString = String.join("\n", expectedList) + "\n";
		webSourceFileReader = new WebSourceFileReader();
	}

    @Test
	public void testReadFileIntoListWeb() throws IOException {
		List<String> actualList = webSourceFileReader.readFileIntoList(url);
		
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReadFileIntoStringWeb() throws IOException {
		String actuals = webSourceFileReader.readFileIntoString(url);
				
		Assert.assertEquals(expectedString, actuals);
	}
}
