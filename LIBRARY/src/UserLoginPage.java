import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UserLoginPage extends JFrame implements ActionListener {
    JLabel userIdLabel, passwordLabel;
    JTextField userIdField;
    JPasswordField passwordField;
    JButton loginButton;

    public UserLoginPage() {
        setTitle("User Login");
        setLayout(null);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // User ID Field (renamed from username)
        userIdLabel = new JLabel("User ID:");
        userIdLabel.setBounds(50, 50, 100, 30);
        add(userIdLabel);
        userIdField = new JTextField();
        userIdField.setBounds(150, 50, 200, 30);
        add(userIdField);

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
        // Get the entered user_id and password
        String userId = userIdField.getText();
        String password = new String(passwordField.getPassword());

        // Establish a connection to the database and validate credentials
        Conn conn = new Conn();

        try {
            // Query the database to check if the user_id and password are correct
            String query = "SELECT * FROM users WHERE user_id = ? AND password = ?";
            PreparedStatement pst = conn.c.prepareStatement(query);
            pst.setString(1, userId);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // If credentials are valid, move to User Home Page
                dispose();  // Close the login page
                new ViewUserPage();  // User home page after successful login
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
        new UserLoginPage();  // Launch the User Login Page
    }
}
