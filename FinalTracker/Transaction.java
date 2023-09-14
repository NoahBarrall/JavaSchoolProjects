import java.util.Date;

/*
 * 
 * @author Ethan Santoro and Noah Barrall
 * 
 */

public class Transaction {
    
    private String date;
    private String description;
    private Double amount;

    // Getter methods for the private instance variables
    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    // Returns the amount as a formatted string
    public String getAmountString() {
        String amountString;
        if (amount >= 0.0) {
            amountString = String.format("$%.2f", amount);
        } else
            amountString = String.format("-$%.2f", amount * (-1.0));
        return amountString;
    }

    // Takes the Description and Amount and sets the equal with a date
    public Transaction(String description, double amount) {
        // Date is a different data type from a string, so it needs to be converted separately
        Date date = new Date();
        // Convert Date class to a string
        String formattedDate = String.format("%tD", date);
        this.date = formattedDate;
        this.description = description;
        this.amount = amount;
    }

    public Transaction(String fileData) {
        int firstComma = fileData.indexOf(",", 0);
        int secondComma = fileData.indexOf(",", firstComma + 1);
        date = fileData.substring(0, firstComma);
        description = fileData.substring(firstComma + 1, secondComma);
        amount = Double.parseDouble(fileData.substring(secondComma + 1));
    }

    // Convert information from date, description, and amount into a single string
    @Override
    public String toString() {
        String information = date + "," + description + "," + amount;
        return information;
    }
}
