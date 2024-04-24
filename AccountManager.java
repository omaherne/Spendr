import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccountManager {
    private static final String USER_FILE = "users.txt";
    private ArrayList<User> users;

    public AccountManager() {
        this.users = new ArrayList<>();
        loadUsers(); // Load users from file when initialized
    }

    public void addUser(User user) {
        users.add(user);
        saveUsers(); // Save users to file
    }

    public User getUserByUsername(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
    }

    public boolean checkCredentials(String username, String password) {
        User user = getUserByUsername(username);
        if (user == null) {
            return false; // User not found
        }
        return user.checkPassword(password); // Check if the password matches
    }

    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (User user : users) {
                writer.write(user.getUsername() + "," + user.getEmail() + "," + user.getPassword());
                writer.newLine(); // Write each user on a new line
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    private void loadUsers() {
        File file = new File(USER_FILE);
        if (!file.exists()) {
            return; // If the file doesn't exist, there's nothing to load
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) { // Ensure proper format
                    User user = new User(parts[0], parts[1], parts[2]); // Username, Email, Hashed Password
                    users.add(user);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }
}