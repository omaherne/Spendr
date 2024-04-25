import java.util.Scanner;

import javax.swing.SwingUtilities;

public class SpendrDemo{
    private static Scanner scanner = new Scanner(System.in);
    private static AccountManager accountManager = new AccountManager(); // Instantiate the AccountManager

    public static void main(String[] args) {
        //This line initializes/display all the GUI
        SwingUtilities.invokeLater(() -> {
            DebtPlanGUI frame = new DebtPlanGUI();
            frame.setVisible(true);
        });
        SwingUtilities.invokeLater(() -> {
            SpendPlanGUI frame = new SpendPlanGUI();
            frame.setVisible(true);
        });
        SwingUtilities.invokeLater(() -> {
            SavePlanGUI frame = new SavePlanGUI();
            frame.setVisible(true);
        });
        SwingUtilities.invokeLater(() -> {
            RetirePlanGUI frame = new RetirePlanGUI();
            frame.setVisible(true);
        });
        SpendrGUI LoginPage = new SpendrGUI();
    }
}