import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// To run this program, compile it using javac and then run the compiled class file using java.
// For example:
// 1. Open Terminal.
// 2. Navigate to the directory where this file is located.
// 3. Compile the file using the following command:
//    javac TransactionBreakdownUI.java
// 4. Run the compiled program using the following command:
//    java TransactionBreakdownUI

public class TransactionBreakdownUI extends JFrame {
    public TransactionBreakdownUI() {
        setTitle("Spendr - Transaction Breakdown");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        JLabel titleLabel = new JLabel("Transaction Breakdown");
        titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);

        JComboBox<String> timeRangeComboBox = new JComboBox<>(new String[]{"Last 24 Hours", "Last Week", "Last Month", "Last Fiscal Quarter", "Last Year", "Lifetime"});
        timeRangeComboBox.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        mainPanel.add(timeRangeComboBox);

        JButton viewButton = new JButton("View Transactions");
        viewButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        mainPanel.add(viewButton);

        JTextArea resultTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        mainPanel.add(scrollPane);

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTimeRange = (String) timeRangeComboBox.getSelectedItem();
                // display transactions based on the selected time range
                String transactions = fetchTransactions(selectedTimeRange); // Placeholder method
                resultTextArea.setText(transactions);
            }
        });

        setVisible(true);
    }

    //fetch transactions based on the selected time range
    private String fetchTransactions(String selectedTimeRange) {
        // shows transactions in history
        StringBuilder transactions = new StringBuilder();
        Random random = new Random();
        int numTransactions = random.nextInt(10) + 1; // Generate random number of transactions (1-10)
    
        transactions.append("Transactions for ").append(selectedTimeRange).append(":\n");
    
        for (int i = 1; i <= numTransactions; i++) {
            // Generate random transaction details
            String transactionType = random.nextBoolean() ? "Deposit" : "Withdrawal";
            double amount = random.nextDouble() * 1000; // Generate random amount (0-1000)
            String currency = "USD";
            String merchant = "Merchant ";
    
            // Append transaction details to the transactions string
            transactions.append("Transaction ").append(i).append(": ")
                        .append(transactionType).append(" - ")
                        .append(currency).append(" ").append(String.format("%.2f", amount)).append(" at ")
                        .append(merchant).append("\n");
        }
    
        return transactions.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TransactionBreakdownUI::new);
    }
}
