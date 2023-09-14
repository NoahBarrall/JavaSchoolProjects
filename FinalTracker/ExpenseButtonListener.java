import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * 
 * @author Ethan Santoro and Noah Barrall
 * 
 */

class ExpenseButtonListener implements ActionListener {
    private ExpenseTrackerGUI expenseTracker;

    public ExpenseButtonListener(ExpenseTrackerGUI expenseTracker) {
        this.expenseTracker = expenseTracker;
    }

    public void actionPerformed(ActionEvent event) {
        // Creates new fields for input
        JTextField descriptionField = new JTextField();
        JTextField amountField = new JTextField();

        // Sets fields to Description and Amount
        Object[] fields = {"Description:", descriptionField, "Amount:", amountField};
        int result = JOptionPane.showConfirmDialog(null, fields, "Expense", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // Get the values entered in the text fields
            String description = descriptionField.getText();
            double amount;
            try {
                amount = Double.parseDouble(amountField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input");
                return;
            }

            // Subtract the expense from the balance
            double newBalance = expenseTracker.getBalance() - amount;
            expenseTracker.setBalance(newBalance);
            // Formatting for 2 decimal places
            JOptionPane.showMessageDialog(null, "$" + String.format("%.2f", amount) + " spent on " + description);

            // Create a record of the transaction
            Transaction t = new Transaction(description, amount * (-1));
            expenseTracker.writeToCsv(t.toString());
            expenseTracker.addRowToTable(t);
            // Add the new transaction to the list of transactions
            expenseTracker.addTransaction(t);
        }
    }
}
