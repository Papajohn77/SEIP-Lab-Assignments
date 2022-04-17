import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;

/**
 * The purpose of this class is to generate a histogram for the grades included
 * in the file whose path will be provided as an argument.
 * 
 * @author  Ioannis Papadatos
 * @since   2022-04-17
 */
public class HistogramGenerator {

    /**
     * Receives the path to the file containing the grades. Efficiently reads the 
     * file and processes it line by line until it encounters the first empty line. 
     * Caution: if the file containing the grades encompasses empty lines, all the 
     * grades after the first empty line will be ignored. Finally, it returns a list 
     * containing the grades included in the file whose path was provided as an 
     * argument.
     * 
     * In case the file can't be found, can't be read or it contains non integer 
     * data the program will be terminated with exit code 1 and the appropriate 
     * message will be displayed on the screen.
     * 
     * @param gradesFilePath the path to the file containing the grades.
     * @return a list containing the grades included in the file whose path was 
     *         provided as an argument.
     */
    public static List<Integer> readGrades(String gradesFilePath) {
        List<Integer> grades = new ArrayList<>();

        try (
            BufferedReader br = new BufferedReader(new FileReader(gradesFilePath))
        ) {
            String grade;
            while((grade = br.readLine()) != null) {
                grades.add(Integer.parseInt(grade));
            }
        } catch (FileNotFoundException e) {
            System.err.println(
                "File not found: The path you provided for the file containing "
                + "the grades was wrong."
            );
            System.exit(1);
        } catch (IOException e) {
            System.err.println(
                "There was an error in reading the file."
                + "\n Please make sure that the provided file has not been deleted "
                + "or moved."
            );
            System.exit(1);
        } catch (NumberFormatException e) {
            System.err.println(
                "Failed to convert a line of the provided file to a grade!"
                + "\nPlease make sure that the provided file contains only "
                + "integers, one per line."
            );
            System.exit(1);
        }

        return grades;
    }

    /**
     * Receives a list containing the grades and returns an array whose indexes 
     * correspond to the grades and its values correspond to the frequency of 
     * each grade.
     * 
     * @param grades a list containing the grades.
     * @return an array whose indexes correspond to the grades and its values 
     *         correspond to the frequency of each grade.
     */
    public static int[] calculateGradeFrequencies(List<Integer> grades) {
        int[] gradeFrequencies = new int[Collections.max(grades) + 1];
        for (int grade : grades) {
            gradeFrequencies[grade] += 1;
        }
        return gradeFrequencies;
    }

    /**
     * Receives an array whose indexes correspond to the grades and its values 
     * correspond to the frequency of each grade and uses it to generate the 
     * histogram of the grades and display it on the screen. The generated 
     * histogram is not preserved after the program is terminated.
     * 
     * @param gradeFrequencies an array whose indexes correspond to the grades and 
     *                         its values correspond to the frequency of each grade.
     */
    public static void generateGradesHistogram(int[] gradeFrequencies) {
        XYSeries data = new XYSeries("Random");
        for (int i = 0; i < gradeFrequencies.length; i++) {
            data.add(i, gradeFrequencies[i]);
        }
        XYSeriesCollection dataset = new XYSeriesCollection(data);

        JFreeChart histogram = ChartFactory.createXYLineChart(
            "Grades Histogram",
            "Grade",
            "Frequency",
            dataset,
            PlotOrientation.VERTICAL,
            false,
            false,
            false
        );

        ChartFrame frame = new ChartFrame("Grades Histogram", histogram);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        String gradesFilePath = args[0];
        List<Integer> grades = readGrades(gradesFilePath);
        int[] gradeFrequencies = calculateGradeFrequencies(grades);
        generateGradesHistogram(gradeFrequencies);
    }
}
