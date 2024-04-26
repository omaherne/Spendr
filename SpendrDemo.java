import java.util.Scanner;

import javax.swing.SwingUtilities;

public class SpendrDemo{
    private static Scanner scanner = new Scanner(System.in);
    private static AccountManager accountManager = new AccountManager(); // Instantiate the AccountManager

    public static void main(String[] args) {
        //This line initializes/display all the GUI=
        DebtPlanGUI debt = new DebtPlanGUI();
        SpendPlanGUI spend = new SpendPlanGUI();
        SavePlanGUI save = new SavePlanGUI();
        RetirePlanGUI retire = new RetirePlanGUI();
        SpendrGUI LoginPage = new SpendrGUI();
        TransactionBreakdownUI transaction = new TransactionBreakdownUI();
    }
}