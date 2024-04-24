import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main{
    private static Scanner scanner = new Scanner(System.in);
    private static AccountManager accountManager = new AccountManager(); // Instantiate the AccountManager

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close(); // Close the scanner when done
    }

    private static void registerUser() {
        System.out.println("Register a new user:");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        if (accountManager.getUserByUsername(username) != null) {
            System.out.println("Username already exists. Try a different one.");
            return;
        }

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User newUser = new User(username, email, password); // Create a new user
        accountManager.addUser(newUser); // Add to the account manager

        System.out.println("User registered successfully!");
    }

    private static void loginUser() {
        System.out.println("Login:");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (accountManager.checkCredentials(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}