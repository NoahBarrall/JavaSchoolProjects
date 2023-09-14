/**
 * @author David Owen and Noah Barrall
 */
public class Month {
    // Instance variables
    private int year;
    private int month;  // Jan is 1 not 0
    private double avgHigh;
    private double avgLow;
    // Constructor(s)
    public Month(int year, int month, double avgHigh,
            double avgLow) {
        this.year = year;
        this.month = month;
        this.avgHigh = avgHigh;
        this.avgLow = avgLow;
    }
    // Just as you can have multiple functions (or methods)
    // with the same name, you can have multiple constructors.
    // This second constructor provides a convenient way to
    // create a Month instance from a line of data read from
    // the input file.
    public Month(String dataLine) {
        String[] values = dataLine.split(",");
        
        // First value from the line is in YYYY/MM format.
        // So year will come from characters 0-3.
        String yearString = values[0].substring(0, 4);
        this.year = Integer.parseInt(yearString);
        // ... And month will come from characters 5-6.
        String monthString = values[0].substring(5, 7);
        this.month = Integer.parseInt(monthString);
        this.avgHigh = Double.parseDouble(values[1]);
        this.avgLow = Double.parseDouble(values[2]);
    }
    // Additional methods
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public double getAvgHigh() {
        return avgHigh;
    }
    public double getAvgLow() {
        return avgLow;
    }
    // A typical "getter" method simply returns the value of
    // an instance variable.  But you can make one more complex
    // if you want to.  From the point of view of code outside
    // this class, this looks a typical getter method, but
    // inside it's implemented by doing a calculation on the
    // instance variables and returning the result.
    public double getAvgMid() {
        return (avgHigh + avgLow) / 2;
    }
}