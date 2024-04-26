import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpendPlanGUI extends JFrame implements ActionListener {
    private JTextField incomeField;
    private JButton calculateButton;
    private JTextArea balanceLabel;

    public SpendPlanGUI() {
        // Set up the frame
        setTitle("Spending Plan Calculator");
        setBounds(800, 150, 800, 600);
        setLayout(new GridLayout(3, 1)); // rows, cols, hgap, vgap

        // Create and add components

        add(new JLabel("Monthly Income:"));
        incomeField = new JTextField();
        
        add(incomeField);
        incomeField.setSize(10, 10);
        

        calculateButton = new JButton("Calculate Spend Plan");
        calculateButton.addActionListener(this);
        add(calculateButton);

        balanceLabel = new JTextArea("Your budget will appear here");
        balanceLabel.setBounds(240, 280, 100, 200);
        add(balanceLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double income = Double.parseDouble(incomeField.getText());

            if(income < 3000) {
                balanceLabel.setText("you cannot afford to live alone");
                return;
            }
            //rent
            double rent = income * 0.25;
            income = income - rent;

            //utilities
            double utilities = rent * 0.33;
            income = income - utilities;

            //insurance
            double insurance = 200;
            income = income - insurance;

            //groceries
            double groceries = 500;
            income = income - groceries;

            //phone
            double phone = 100;
            income = income - phone;

            //car 
            double car = income * 0.10;
            income = income - car;

            //fun money
            double fun_money = income * 0.75;
            income = income - fun_money;
            
            //investment
            double investment = income * 0.5;
            
            //retirement
            double retirement = income * 0.5;

            
            balanceLabel.setText("Budget Sheet: \nRent: $" + rent + "\nUtilities: $" + utilities + "\nInsurance: $" + insurance + "\nGroceries: $" + groceries + "\nPhone: $" + phone + "\nCar: $" + car + "\nSave: $" + investment + "\nRetirement: $" + retirement + "\nMoney to Spend: $" + fun_money);
        } catch (NumberFormatException ex) {
            balanceLabel.setText("Please enter valid numbers.");
        }
    }
}
