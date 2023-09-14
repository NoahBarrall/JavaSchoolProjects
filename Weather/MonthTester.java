import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @author Noah Barrall
 */

public class MonthTester {
    
    // Use this function (call it from main) to read input from
    // a CSV data file into an array of Strings.  (Don't worry if
    // you don't understand the code in this function.  I don't
    // expect you to at this point in the course.)
    private static String[] readLines(String filename) {

        try {
            List<String> lineList =
                Files.readAllLines(Path.of(filename));
            String[] lines =
                lineList.toArray(new String[lineList.size()]);
            return lines;

        } catch (IOException e) {
            System.err.println(
                "Trouble reading from file: " + filename);
            return new String[] {};
        }
    }

    public static void main(String[] args) {
        int year = 2022;

        if (args.length >= 1) {
            year = Integer.parseInt(args[0]);
        }

        Draw draw = new Draw();

        String[] lines = readLines("monthly.csv");
        Month[] months = new Month[12];


        int monthCounter = 0;
        for (int i = 0; i < lines.length; i++) {
            String yearString = lines[i].substring(0,4);
            int lineYear = Integer.parseInt(yearString);

            if (lineYear == year) {
                months[monthCounter] = new Month(lines[i]);
                monthCounter++;
            }
        }

        draw.setXscale(0, 13);
        draw.setYscale(0, 100);

        for (int i = 0; i < months.length; i++) {
            int x = months[i].getMonth();
            double y = months[i].getAvgMid();
            double halfHeight = months[i].getAvgHigh() - y;

            draw.setPenColor(Color.LIGHT_GRAY);
            draw.filledRectangle(x, y, 0.4, halfHeight);

            draw.setPenColor(Color.BLACK);
            draw.filledRectangle(x, y, 0.4, 0.3);
        }
    }
}
