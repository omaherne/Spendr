public class User {
    private String username;
    private String email;
    private String password;

    public User() {
        // Default constructor
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // getters and setters
    public String getUsername(){
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // methods
    public boolean checkPassword(String plainPassword) {
        return (plainPassword.equals(this.password)); // Check if the given password matches the hashed one
    }
}
