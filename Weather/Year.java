/**
 * @author David Owen and Noah Barrall
 */
public class Year {
    // Instance variables
    private int year;
    private double avgHigh;
    private double avgLow;
    // Constructor(s)
    public Year(int year, double avgHigh, double avgLow) {
        this.year = year;
        this.avgHigh = avgHigh;
        this.avgLow = avgLow;
    }

    public Year(Month[] months) {
        // Assuming months is an array of 12 Month instances...
        // this.year should be set to the value of the first (or any)
        // Month's year.
        this.year = months[0].getYear();     
        // this.avgHigh should be set to the average of the 12
        // Months' high temperature values.
        double totalHigh = 0;

        for (int i = 0; i < 12; i++) {
            totalHigh += months[i].getAvgHigh();
        }

        this.avgHigh = totalHigh/12.0;
        
        // this.avgLow should be set to the average of the 12
        // Months' low temperature values.
        double totalLow = 0;

        for (int i = 0; i < 12; i++) {
            totalLow += months[i].getAvgLow();
        }

        this.avgLow = totalLow/12.0;
    }
    // Additional methods
    public int getYear() {
        return year;
    }
    public double getAvgHigh() {
        return avgHigh;
    }
    public double getAvgLow() {
        return avgLow;
    }
    public double getAvgMid() {
        return (avgHigh + avgLow) / 2;
    }
}