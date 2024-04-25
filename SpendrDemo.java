import java.util.Scanner;

public class SpendrDemo{
    private static Scanner scanner = new Scanner(System.in);
    private static AccountManager accountManager = new AccountManager(); // Instantiate the AccountManager

    public static void main(String[] args) {
        //This line initializes/display all the GUI
        SpendrGUI LoginPage = new SpendrGUI();
        
    }
}