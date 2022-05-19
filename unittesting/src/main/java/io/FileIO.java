package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* The FileIO provides simple file input/output operations
* that serve as hands-on practice on Unit Testing.
*/
public class FileIO {

	/**
	 * Reads a file that contains numbers line by line 
	 * and returns an array of the integers found in the file.
	 * @param filepath the file that contains the numbers
	 * @return an array of numbers
	 * @exception IllegalArgumentException when the given file does not exist
	 * @exception IllegalArgumentException when the given file is empty
	 * @exception IllegalArgumentException when the given file does not contain only integers
	 */
	public int[] readFile(String filepath) {
		File file = new File(filepath);
		if (!file.exists()) 
			throw new IllegalArgumentException("Input file does not exist");

		List<Integer> numbersList = new ArrayList<>();
		try (
			BufferedReader reader = new BufferedReader(new FileReader(file))
		) {
			String line;
			while ((line = reader.readLine()) != null) {
				numbersList.add(Integer.parseInt(line));
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(
				"Input file does not contain only integers");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (numbersList.size() == 0)
			throw new IllegalArgumentException("Input file is empty");

		return numbersList.stream().mapToInt(i -> i).toArray();
	}

}
