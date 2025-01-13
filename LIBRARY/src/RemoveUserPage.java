import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RemoveUserPage extends JFrame implements ActionListener {
    JLabel userIdLabel;
    JTextField userIdField;
    JButton searchButton, removeButton, backButton;
    JTextArea userDetailsArea;

    public RemoveUserPage() {
        setTitle("Remove User");
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

        // User Details Area (display user info for confirmation)
        userDetailsArea = new JTextArea();
        userDetailsArea.setBounds(50, 100, 500, 150);
        userDetailsArea.setEditable(false);
        add(userDetailsArea);

        // Remove User Button
        removeButton = new JButton("Remove User");
        removeButton.setBounds(200, 270, 200, 40);
        removeButton.addActionListener(this);
        removeButton.setEnabled(false);  // Disabled initially
        add(removeButton);

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
                // Simulate a search process (replace this with actual database lookup)
                // For example, search the database or list of users.
                // This is just a placeholder:
                String userInfo = searchUserById(userId);

                if (userInfo != null) {
                    userDetailsArea.setText(userInfo);
                    removeButton.setEnabled(true);  // Enable remove button when user is found
                } else {
                    userDetailsArea.setText("No user found with ID/Username: " + userId);
                    removeButton.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a User ID or Username.");
            }
        } else if (ae.getSource() == removeButton) {
            String userId = userIdField.getText().trim();

            // Simulate removal of user (replace with actual removal code)
            boolean success = removeUserById(userId);
            if (success) {
                JOptionPane.showMessageDialog(this, "User with ID/Username " + userId + " has been removed.");
                userDetailsArea.setText("");
                userIdField.setText("");
                removeButton.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to remove user.");
            }
        } else if (ae.getSource() == backButton) {
            dispose();
            new ManageUsersPage();  // Go back to Manage Users Page
        }
    }

    // Simulate a user search by ID (replace with your database logic)
    private String searchUserById(String userId) {
        // Placeholder logic - you should replace this with actual logic (e.g., querying a database)
        if ("user123".equals(userId)) {
            return "User found:\nID: user123\nName: John Doe\nEmail: john@example.com\nMembership: Active";
        }
        return null;  // Return null if user not found
    }

    // Simulate removing a user by ID (replace with your database logic)
    private boolean removeUserById(String userId) {
        // Placeholder logic - replace with actual removal logic (e.g., database operation)
        if ("user123".equals(userId)) {
            // Simulate successful removal
            return true;
        }
        return false;  // Simulate failure if user not found
    }

    public static void main(String[] args) {
        new RemoveUserPage();
    }
}
