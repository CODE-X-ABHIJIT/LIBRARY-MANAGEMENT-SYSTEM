import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AdminLoginPage extends JFrame implements ActionListener {
    JLabel usernameLabel, passwordLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    public AdminLoginPage() {
        setTitle("Admin Login");
        setLayout(null);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Username Field
        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 100, 30);
        add(usernameLabel);
        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 200, 30);
        add(usernameField);

        // Password Field
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 30);
        add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 30);
        add(passwordField);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 30);
        loginButton.addActionListener(this);
        add(loginButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Get the entered username and password
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Establish a connection to the database and validate credentials
        Conn conn = new Conn();

        try {
            // Query the database to check if the username and password are correct
            String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
            PreparedStatement pst = conn.c.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // If credentials are valid, move to Admin Home Page
                dispose();  // Close the login page
                new AdminHomePage();  // Admin home page after successful login
            } else {
                // If credentials are invalid, show an error message
                JOptionPane.showMessageDialog(this, "Invalid credentials, please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to the database.");
        }
    }

    public static void main(String[] args) {
        new AdminLoginPage();  // Launch the Admin Login Page
    }
}
