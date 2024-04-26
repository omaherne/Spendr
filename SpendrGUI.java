import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
	
public class SpendrGUI {
    public JFrame frmMainWindow;
	public JFrame loginPage;
	public JFrame registerPage;
    public JLabel lblLogin;
	public JLabel lblRegister;
	public JTextField txtFullName;
    public JButton btnLogin;
	public JButton btnRegister;
	public JLabel lblEmail;
	public JLabel lblUsername;
	public JLabel lblPassword;
	public JLabel lblConfirmPassword;
	public JTextField txtEmail;
	public JTextField txtUsername;
	public JPasswordField txtPassword;
	public JPasswordField txtConfirmPassword;
	public JLabel lblPasswordIncorrect;
	public JFrame spendrHome;
	private static AccountManager accountManager = new AccountManager(); // Instantiate the AccountManager

    public SpendrGUI(){
    	//Create the frame
		frmMainWindow = new JFrame("Spendr"); // homepage 
		frmMainWindow.setBounds(800, 150, 800, 600);
		frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes the program to end when the window is closed
		frmMainWindow.setResizable(true); // the window can be resizable
		frmMainWindow.setLayout(null);
		
		lblLogin = new JLabel("Returning User? Login.");
		lblLogin.setBounds(240, 220, 160, 40);
		btnLogin = new JButton("Login");
		btnLogin.setBounds(400, 220, 100, 40);

		lblRegister= new JLabel("New User? Register Now!");
		lblRegister.setBounds(240, 280, 160, 40);
		btnRegister = new JButton("Register");
		btnRegister.setBounds(400, 280, 100, 40);

		frmMainWindow.add(lblLogin);
		frmMainWindow.add(btnLogin);
		frmMainWindow.add(lblRegister);
		frmMainWindow.add(btnRegister);
		//Make the frame visible
		frmMainWindow.setVisible(true);

		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				loginPage = new JFrame("Login"); // homepage 
				loginPage.setBounds(800, 150, 800, 600);
				loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes the program to end when the window is closed
				loginPage.setResizable(true); // the window can be resizable
				loginPage.setLayout(null);

				lblUsername = new JLabel("Enter username:");
				lblUsername.setBounds(240, 230, 160, 40);
				txtUsername = new JTextField();
				txtUsername.setBounds(400, 230, 100, 40);

				lblPassword = new JLabel("Enter password:");
				lblPassword.setBounds(240, 280, 160, 40);
				txtPassword = new JPasswordField();
				txtPassword.setBounds(400, 280, 100, 40);

				btnLogin = new JButton("Login");
				btnLogin.setBounds(400, 340, 100, 40);

				lblPasswordIncorrect = new JLabel("Username or password does not match.");
				lblPasswordIncorrect.setBounds(400, 380, 100, 20);

				loginPage.add(lblUsername);
				loginPage.add(txtUsername);
				loginPage.add(lblPassword);
				loginPage.add(txtPassword);
				loginPage.add(btnLogin);
				loginPage.setVisible(true);

				btnLogin.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if (!accountManager.checkCredentials(txtUsername.getText(), new String(txtPassword.getPassword()))) {
							loginPage.add(lblPasswordIncorrect);
							loginPage.revalidate();
							loginPage.repaint();
						} else {
							loginPage.setVisible(false);
						}
					}
				});
			}
		});

		btnRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				registerPage = new JFrame("Register"); // homepage 
				registerPage.setBounds(800, 150, 800, 600);
				registerPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes the program to end when the window is closed
				registerPage.setResizable(true); // the window can be resizable
				registerPage.setLayout(null);

				lblEmail = new JLabel("Enter email:");
				lblEmail.setBounds(240, 180, 160, 40);
				txtEmail = new JTextField();
				txtEmail.setBounds(400, 180, 100, 40);

				lblUsername = new JLabel("Enter username:");
				lblUsername.setBounds(240, 230, 160, 40);
				txtUsername = new JTextField();
				txtUsername.setBounds(400, 230, 100, 40);

				lblPassword = new JLabel("Enter password:");
				lblPassword.setBounds(240, 280, 160, 40);
				txtPassword = new JPasswordField();
				txtPassword.setBounds(400, 280, 100, 40);

				lblConfirmPassword = new JLabel("Confirm password:");
				lblConfirmPassword.setBounds(240, 330, 160, 40);
				txtConfirmPassword = new JPasswordField();
				txtConfirmPassword.setBounds(400, 330, 100, 40);

				btnRegister = new JButton("Register");
				btnRegister.setBounds(400, 400, 100, 40);

				lblPasswordIncorrect = new JLabel("Username already exists");
				lblPasswordIncorrect.setBounds(380, 440, 200, 20);


				registerPage.add(lblEmail);
				registerPage.add(txtEmail);
				registerPage.add(lblUsername);
				registerPage.add(txtUsername);
				registerPage.add(lblPassword);
				registerPage.add(txtPassword);
				registerPage.add(lblConfirmPassword);
				registerPage.add(txtConfirmPassword);
				registerPage.add(btnRegister);
				registerPage.setVisible(true);

				btnRegister.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if (accountManager.getUserByUsername(txtUsername.getText()) != null) {
							System.out.println("username already exists");
							registerPage.add(lblPasswordIncorrect);
							registerPage.revalidate();
							registerPage.repaint();
							return;
						}
						User newUser = new User(txtUsername.getText(), txtEmail.getText(), new String(txtPassword.getPassword())); // Create a new user
						accountManager.addUser(newUser); // Add to the account manager
						registerPage.setVisible(false);
					}
				});
			}
		});
    }

	// helper methods
	private static void registerUser() {
        /*String username = txtEmail.getText();

        if (accountManager.getUserByUsername(username) != null) {
            System.out.println("Username already exists. Try a different one.");
            return;
        }

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        String password = scanner.nextLine();
        User newUser = new User(username, email, password); // Create a new user
        accountManager.addUser(newUser); // Add to the account manager

        System.out.println("User registered successfully!");*/
    }
}