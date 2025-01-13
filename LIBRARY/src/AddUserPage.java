import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddUserPage extends JFrame implements ActionListener {

    JTextField nameField, emailField, passwordField;
    JRadioButton newUserRadio, existingUserRadio;
    ButtonGroup userGroup;
    JButton submitButton, cancelButton;

    public AddUserPage() {
        setTitle("Add User");
        setLayout(null);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Name Field
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 50, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 50, 200, 30);
        add(nameField);

        // Email Field
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 100, 100, 30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 100, 200, 30);
        add(emailField);

        // Password Field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 150, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 200, 30);
        add(passwordField);

        // User Type Radio Buttons
        JLabel userTypeLabel = new JLabel("User Type");
        userTypeLabel.setBounds(50, 200, 100, 30);
        add(userTypeLabel);

        newUserRadio = new JRadioButton("New User", true);
        newUserRadio.setBounds(150, 200, 100, 30);
        add(newUserRadio);

        existingUserRadio = new JRadioButton("Existing User");
        existingUserRadio.setBounds(250, 200, 100, 30);
        add(existingUserRadio);

        // Grouping the radio buttons
        userGroup = new ButtonGroup();
        userGroup.add(newUserRadio);
        userGroup.add(existingUserRadio);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setBounds(100, 250, 100, 40);
        submitButton.addActionListener(this);
        add(submitButton);

        // Cancel Button
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250, 250, 100, 40);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            String userType = "";

            if (newUserRadio.isSelected()) {
                userType = "New User";
            } else if (existingUserRadio.isSelected()) {
                userType = "Existing User";
            }

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required.");
            } else {
                // Code to add user data
                JOptionPane.showMessageDialog(this, "User added successfully. Type: " + userType);
                dispose();
                new AdminHomePage(); // Return to Admin Home Page
            }
        } else if (ae.getSource() == cancelButton) {
            dispose();
            new ManageUsersPage(); // Return to Admin Home Page
        }
    }

    public static void main(String[] args) {
        new AddUserPage();
    }
}
