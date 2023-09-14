import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @author Noah Barrall
 */

public class YearTester {
    
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
   
        String[] lines = readLines("monthly.csv");
        Month[] months = new Month[lines.length];

        for (int i = 0; i < months.length; i++) {
            months[i] = new Month(lines[i]);
        }

        Year[] years = new Year[lines.length/12];

        for (int i = 0; i < years.length; i++) {
            Month[] tempMonth = new Month[12];

            for (int j = 0; j < 12; j++) {
                tempMonth[j] = months[(i * 12) + j];
            }

            years[i] = new Year(tempMonth);
        }

        Draw window = new Draw();
        window.setCanvasSize(800, 600);

        window.setXscale(years[0].getYear(), years[years.length - 1].getYear());
        window.setYscale(30, 70);

        for (int i = 0; i < years.length; i++) {
            int x = years[i].getYear();
            double y = years[i].getAvgMid();
            double halfHeight = years[i].getAvgHigh() - y;

            window.setPenColor(Color.LIGHT_GRAY);
            window.filledRectangle(x, y, 0.4, halfHeight);

            window.setPenColor(Color.BLACK);
            window.filledRectangle(x, y, 0.4, 0.3);
        }
        double totalMid = 0;
        for (int i = 0; i < years.length; i++) {
            totalMid += years[i].getAvgMid();
        }
        double midpoint = totalMid / years.length;
        window.line(years[0].getYear(), midpoint, years[years.length-1].getYear(), midpoint);
        window.line(years[0].getYear(), midpoint + 2, years[years.length-1].getYear(), midpoint + 2);
        window.line(years[0].getYear(), midpoint + 4, years[years.length-1].getYear(), midpoint + 4);
        window.line(years[0].getYear(), midpoint - 2, years[years.length-1].getYear(), midpoint - 2);
        window.line(years[0].getYear(), midpoint - 4, years[years.length-1].getYear(), midpoint - 4);
    }
}
