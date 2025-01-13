import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateMembershipPage extends JFrame implements ActionListener {
    JLabel userIdLabel, newTypeLabel;
    JTextField userIdTextField;
    JComboBox<String> newTypeComboBox;
    JButton submitButton, backButton;

    public UpdateMembershipPage() {
        setTitle("Update Membership");
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

        // New Membership Type
        newTypeLabel = new JLabel("New Membership Type:");
        newTypeLabel.setBounds(80, 100, 150, 30);
        add(newTypeLabel);
        newTypeComboBox = new JComboBox<>(new String[]{"6 months", "1 year", "2 years"});
        newTypeComboBox.setBounds(250, 100, 200, 30);
        add(newTypeComboBox);

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
            // Handle Update Membership Logic
            JOptionPane.showMessageDialog(this, "Membership updated successfully.");
            dispose();
            new ManageUsersPage(); // Redirect to Manage Users Page
        } else if (ae.getSource() == backButton) {
            dispose();
            new ManageUsersPage(); // Go back to Manage Users Page
        }
    }

    public static void main(String[] args) {
        new UpdateMembershipPage();
    }
}
