import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.io.*;

/*
 * 
 * @author Ethan Santoro and Noah Barrall
 * 
 */

public class ExpenseTrackerGUI extends JFrame {
    private double balance = 0.0;
    private JLabel balanceLabel;
    private JButton expenseButton, depositButton;
    private String userName;
    private String fileName;
    private LinkedList<Transaction> transactions;
    private JPanel balancePanel;
    private DefaultTableModel tableModel;
    private JTable table;
    private JScrollPane scrollpane;

    // Add a transaction to the list of transactions
    // Needs to be a function because the list is private, so buttons can't directly access it
    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public double getBalance() {
        return balance;
    }

    // Setter method for the balance variable
    public void setBalance(double newBalance) {
        balance = newBalance;
        // Formatting for 2 decimal places
        String balanceText = String.format("%.2f", balance);
        balanceLabel.setText("Balance: $" + balanceText);
    }

    public ExpenseTrackerGUI() {
        // Create a new list of transactions
        transactions = new LinkedList<Transaction>();

        // Ask for users name in order to be able to recall their account
        userName = JOptionPane.showInputDialog("Enter your name:");
        fileName = userName + ".csv";

        // Setting up of GUI
        setTitle(userName + "'s Expense Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null); // Center the window

        // Create a panel for the balance area
        balancePanel = new JPanel();
        balanceLabel = new JLabel("");
        setBalance(balance);
        balancePanel.add(balanceLabel);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        expenseButton = new JButton("Set Expenses");
        depositButton = new JButton("Deposit Money");

        // Sets size of buttons
        expenseButton.setPreferredSize(new Dimension(125, 50));
        depositButton.setPreferredSize(new Dimension(125, 50));

        // Adds styling to the buttons
        expenseButton.setFont(new Font("Arial", Font.BOLD, 12));
        depositButton.setFont(new Font("Arial", Font.BOLD, 12));

        // Adds the buttons to the panel
        buttonPanel.add(expenseButton);
        buttonPanel.add(depositButton);

        // Add the panels to the content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(balancePanel, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        // Create an instance of ExpenseButtonListener
        ExpenseButtonListener expenseButtonListener = new ExpenseButtonListener(this);

        // Create an instance of DepositButtonListener
        DepositButtonListener depositButtonListener = new DepositButtonListener(this);

        // Attach event listeners to the buttons
        expenseButton.addActionListener(expenseButtonListener);
        depositButton.addActionListener(depositButtonListener);

        // Create a table to list transactions
        createBalanceTable();
        scrollpane.setPreferredSize(new Dimension(400, 325));
        // depositButton.setFont(new Font("Arial", Font.BOLD, 12));
        buttonPanel.add(scrollpane);
        // scrollpane.setLocation(100, 100);

        // Check if file already exists
        // If it exists, load data
        File file = new File(fileName);
        if (file.exists()) {
            loadFile();
        }
    }

    /*
     * 
     * Sources used for making of JTable
     * 
     * https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
     * https://docs.oracle.com/javase/8/docs/api/javax/swing/JTable.html
     * https://docs.oracle.com/javase/8/docs/api/javax/swing/table/TableModel.html
     * https://www.tutorialspoint.com/how-to-add-a-new-row-to-jtable-with-insertrow-in-java-swing
     * 
     */

    private void createBalanceTable() {
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        scrollpane = new JScrollPane(table);

        tableModel.addColumn("Date");
        tableModel.addColumn("Description");
        tableModel.addColumn("Amount");
    }

    public void addRowToTable(Transaction t) {
        Object[] information = new Object[3];
        information[0] = t.getDate();
        information[1] = t.getDescription();
        information[2] = t.getAmountString();
        tableModel.insertRow(0, information);
    }

    // Method to write expense or deposit details to a CSV file
    public void writeToCsv(String text) {
        try {
            // Concatenate the userName to ".csv" so that each user has their own separate file
            FileWriter csvWriter = new FileWriter(fileName, true);
            csvWriter.append(text);
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFile() {
        try {
            double balance = 0.0;

            // Open file
            File file = new File(fileName);

            // Read lines
            BufferedReader br = new BufferedReader(new FileReader(file));
            String fileData;
            while ((fileData = br.readLine()) != null) {
                Transaction t = new Transaction(fileData);
                addRowToTable(t);
                balance = balance + t.getAmount();
                transactions.addLast(t);
                setBalance(balance);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class Main {
        public static void main(String[] args) {
            ExpenseTrackerGUI expenseTrackerGUI = new ExpenseTrackerGUI();
            expenseTrackerGUI.setVisible(true);
        }
    }   
}