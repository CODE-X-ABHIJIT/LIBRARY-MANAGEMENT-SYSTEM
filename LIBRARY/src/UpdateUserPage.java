import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateUserPage extends JFrame implements ActionListener {
    JLabel membershipNumberLabel, nameLabel, emailLabel, phoneLabel, membershipTypeLabel;
    JTextField membershipNumberField, nameField, emailField, phoneField;
    JComboBox<String> membershipTypeComboBox;
    JRadioButton extendMembershipRadio, cancelMembershipRadio;
    ButtonGroup membershipOptionGroup;
    JButton updateButton, backButton;

    // Sample data for demonstration (you would usually get this from a database)
    String[] membershipTypes = { "6 months", "1 year", "2 years" };

    public UpdateUserPage() {
        setTitle("Update User");
        setLayout(null);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membership Number
        membershipNumberLabel = new JLabel("Membership Number:");
        membershipNumberLabel.setBounds(50, 30, 150, 30);
        add(membershipNumberLabel);

        membershipNumberField = new JTextField();
        membershipNumberField.setBounds(200, 30, 200, 30);
        add(membershipNumberField);

        // Name
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 70, 150, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200, 70, 200, 30);
        nameField.setEditable(false); // Non-editable
        add(nameField);

        // Email
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 110, 150, 30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200, 110, 200, 30);
        emailField.setEditable(false); // Non-editable
        add(emailField);

        // Phone
        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 150, 150, 30);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(200, 150, 200, 30);
        phoneField.setEditable(false); // Non-editable
        add(phoneField);

        // Membership Type (ComboBox)
        membershipTypeLabel = new JLabel("Membership Type:");
        membershipTypeLabel.setBounds(50, 190, 150, 30);
        add(membershipTypeLabel);

        membershipTypeComboBox = new JComboBox<>(membershipTypes);
        membershipTypeComboBox.setBounds(200, 190, 200, 30);
        membershipTypeComboBox.setEnabled(false); // Non-editable
        add(membershipTypeComboBox);

        // Extend or Cancel Membership
        extendMembershipRadio = new JRadioButton("Extend Membership", true);
        extendMembershipRadio.setBounds(50, 230, 200, 30);
        add(extendMembershipRadio);

        cancelMembershipRadio = new JRadioButton("Cancel Membership");
        cancelMembershipRadio.setBounds(250, 230, 200, 30);
        add(cancelMembershipRadio);

        membershipOptionGroup = new ButtonGroup();
        membershipOptionGroup.add(extendMembershipRadio);
        membershipOptionGroup.add(cancelMembershipRadio);

        // Update Button
        updateButton = new JButton("Update");
        updateButton.setBounds(100, 290, 150, 40);
        updateButton.addActionListener(this);
        add(updateButton);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(300, 290, 150, 40);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == updateButton) {
            // Validate Membership Number
            String membershipNumber = membershipNumberField.getText();
            if (membershipNumber.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Membership Number is required.");
                return;
            }

            // Update User Logic (e.g., update the database)
            String updatedMembershipType = (String) membershipTypeComboBox.getSelectedItem();
            String membershipStatus = extendMembershipRadio.isSelected() ? "Extended" : "Cancelled";

            // Show success message
            JOptionPane.showMessageDialog(this, "User updated successfully with Membership Type: " + updatedMembershipType + " and Status: " + membershipStatus);
        } else if (ae.getSource() == backButton) {
            dispose();
            new ManageUsersPage(); // Go back to Manage Users Page
        }
    }

    public static void main(String[] args) {
        new UpdateUserPage();
    }
}
