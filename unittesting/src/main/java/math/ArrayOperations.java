package math;

import io.FileIO;

import java.util.List;
import java.util.ArrayList;

/**
* The ArrayOperations provides simple array operations
* that serve as hands-on practice on Unit Testing.
*/
public class ArrayOperations {

    /**
     * Iterates over an array of integers, which is created by
     * the numbers contained in the file located at the provided
     * filepath. At each iteration if the number is prime it is
     * included in the result, otherwise it is ignored.
     * @param filepath the file that contains the numbers
     * @param fileIO an instance of the FileIO Class
     * @param myMath an instance of the MyMath Class
     * @return an array of prime numbers
     */
    public int[] findPrimesInFile(String filepath, FileIO fileIO, MyMath myMath)  {
        List<Integer> primeNumbers = new ArrayList<>();

        int[] numbers = fileIO.readFile(filepath);
        for (int number : numbers) {
            try {
                if (myMath.isPrime(number)) {
                    primeNumbers.add(number);
                }
            } catch (IllegalArgumentException e) {
                // Ignore integer < 2 (not prime)
            }
        }
        return primeNumbers.stream().mapToInt(i -> i).toArray();
    }
}
