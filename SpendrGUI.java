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
	public JLabel lblPassword;
	public JLabel lblConfirmPassword;
	public JTextField txtEmail;
	public JTextField txtPassword;
	public JTextField txtConfirmPassword;

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

				

				loginPage.setVisible(true);
			}
		});

		btnRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				registerPage = new JFrame("Register"); // homepage 
				registerPage.setBounds(800, 150, 800, 600);
				registerPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes the program to end when the window is closed
				registerPage.setResizable(true); // the window can be resizable
				registerPage.setLayout(null);

				registerPage.setVisible(true);
			}
		});
    }
}