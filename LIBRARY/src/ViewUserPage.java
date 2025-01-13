import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ViewUserPage extends JFrame implements ActionListener {
    JLabel userIdLabel;
    JTextField userIdField;
    JButton searchButton, backButton, finePayButton;
    JTextArea userDetailsArea;
    double fineAmount;  // Will hold the calculated fine

    public ViewUserPage() {
        setTitle("View User");
        setLayout(null);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // User ID Label
        userIdLabel = new JLabel("Enter User ID or Username:");
        userIdLabel.setBounds(50, 50, 200, 30);
        add(userIdLabel);

        // User ID Text Field
        userIdField = new JTextField();
        userIdField.setBounds(250, 50, 200, 30);
        add(userIdField);

        // Search Button
        searchButton = new JButton("Search");
        searchButton.setBounds(460, 50, 100, 30);
        searchButton.addActionListener(this);
        add(searchButton);

        // User Details Area (display user info)
        userDetailsArea = new JTextArea();
        userDetailsArea.setBounds(50, 100, 500, 150);
        userDetailsArea.setEditable(false);
        add(userDetailsArea);

        // Fine Pay Button
        finePayButton = new JButton("Fine Pay");
        finePayButton.setBounds(200, 270, 200, 40);
        finePayButton.addActionListener(this);
        add(finePayButton);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(200, 320, 200, 40);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchButton) {
            String userId = userIdField.getText().trim();

            if (!userId.isEmpty()) {
                // Simulate searching for a user (replace with actual database logic)
                String userInfo = searchUserById(userId);

                if (userInfo != null) {
                    userDetailsArea.setText(userInfo);
                    fineAmount = getFineAmount(userId);  // Get the fine for the user
                } else {
                    userDetailsArea.setText("No user found with ID/Username: " + userId);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a User ID or Username.");
            }
        } else if (ae.getSource() == finePayButton) {
            // Redirect to Fine Pay Page
            if (fineAmount > 0) {
                new FinePayPage(fineAmount);  // Pass the fine amount to the Fine Pay page
                dispose(); // Close the current page
            } else {
                JOptionPane.showMessageDialog(this, "No pending fines for this user.");
            }
        } else if (ae.getSource() == backButton) {
            dispose();
            new ManageUsersPage(); // Go back to Manage Users Page
        }
    }

    // Simulate searching for a user by ID (replace with actual database query)
    private String searchUserById(String userId) {
        // Placeholder logic - replace with actual logic
        if ("user123".equals(userId)) {
            return "User found:\nID: user123\nName: John Doe\nEmail: john@example.com\nMembership: Active";
        } else if ("user456".equals(userId)) {
            return "User found:\nID: user456\nName: Jane Smith\nEmail: jane@example.com\nMembership: Inactive";
        }
        return null; // Return null if no user found
    }

    // Simulate getting the fine amount for a user (replace with actual fine calculation)
    private double getFineAmount(String userId) {
        // Example logic for calculating fine - this should be replaced with actual logic
        if ("user123".equals(userId)) {
            return 20.0;  // Example fine for user123
        } else if ("user456".equals(userId)) {
            return 50.0;  // Example fine for user456
        }
        return 0.0;  // No fine if user is not found
    }

    public static void main(String[] args) {
        new ViewUserPage();  // Launch the View User Page
    }
}
