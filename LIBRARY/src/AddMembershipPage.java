import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddMembershipPage extends JFrame implements ActionListener {
    JLabel userIdLabel, typeLabel;
    JTextField userIdTextField;
    JComboBox<String> typeComboBox;
    JButton submitButton, backButton;

    public AddMembershipPage() {
        setTitle("Add Membership");
        setLayout(null);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // User ID
        userIdLabel = new JLabel("User ID:");
        userIdLabel.setBounds(80, 50, 100, 30);
        add(userIdLabel);
        userIdTextField = new JTextField();
        userIdTextField.setBounds(250, 50, 200, 30);
        add(userIdTextField);

        // Membership Type
        typeLabel = new JLabel("Membership Type:");
        typeLabel.setBounds(80, 100, 120, 30);
        add(typeLabel);
        typeComboBox = new JComboBox<>(new String[]{"6 months", "1 year", "2 years"});
        typeComboBox.setBounds(250, 100, 200, 30);
        add(typeComboBox);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setBounds(100, 150, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(300, 150, 100, 30);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitButton) {
            // Handle Add Membership Logic
            JOptionPane.showMessageDialog(this, "Membership added successfully.");
            dispose();
            new ManageUsersPage(); // Redirect to Manage Users Page
        } else if (ae.getSource() == backButton) {
            dispose();
            new ManageUsersPage(); // Go back to Manage Users Page
        }
    }

    public static void main(String[] args) {
        new AddMembershipPage();
    }
}
