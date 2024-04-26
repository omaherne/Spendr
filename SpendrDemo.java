import java.util.Scanner;

import javax.swing.SwingUtilities;

public class SpendrDemo{
    private static Scanner scanner = new Scanner(System.in);
    private static AccountManager accountManager = new AccountManager(); // Instantiate the AccountManager

    public static void main(String[] args) {
        //This line initializes/display all the GUI=
        DebtPlanGUI debt = new DebtPlanGUI();
        debt.setVisible(true);
        SpendPlanGUI spend = new SpendPlanGUI();
        spend.setVisible(true);
        SavePlanGUI save = new SavePlanGUI();
        save.setVisible(true);
        RetirePlanGUI retire = new RetirePlanGUI();
        retire.setVisible(true);
        TransactionBreakdownUI transaction = new TransactionBreakdownUI();
        SpendrGUI loginPage = new SpendrGUI();
    }
}