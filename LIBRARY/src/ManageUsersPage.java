import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ManageUsersPage extends JFrame implements ActionListener {
    JButton addUserButton, removeUserButton, viewUsersButton, updateUserButton, backButton, addMembershipButton, updateMembershipButton;

    public ManageUsersPage() {
        setTitle("Manage Users");
        setLayout(null);
        setSize(600, 500);  // Increased size to fit extra buttons
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add User Button
        addUserButton = new JButton("Add User");
        addUserButton.setBounds(200, 50, 200, 40);
        addUserButton.addActionListener(this);
        add(addUserButton);

        // Remove User Button
        removeUserButton = new JButton("Remove User");
        removeUserButton.setBounds(200, 110, 200, 40);
        removeUserButton.addActionListener(this);
        add(removeUserButton);

        // View Users Button
        viewUsersButton = new JButton("View Users");
        viewUsersButton.setBounds(200, 170, 200, 40);
        viewUsersButton.addActionListener(this);
        add(viewUsersButton);

        // Update User Button
        updateUserButton = new JButton("Update User");
        updateUserButton.setBounds(200, 230, 200, 40);
        updateUserButton.addActionListener(this);
        add(updateUserButton);

        // Add Membership Button
        addMembershipButton = new JButton("Add Membership");
        addMembershipButton.setBounds(200, 290, 200, 40);
        addMembershipButton.addActionListener(this);
        add(addMembershipButton);

        // Update Membership Button
        updateMembershipButton = new JButton("Update Membership");
        updateMembershipButton.setBounds(200, 350, 200, 40);
        updateMembershipButton.addActionListener(this);
        add(updateMembershipButton);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(200, 410, 200, 40);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addUserButton) {
            // Redirect to Add User Page
            new AddUserPage();  // Open AddUserPage when clicked
            dispose();           // Close current page
        } else if (ae.getSource() == removeUserButton) {
            // Redirect to Remove User Page
            new RemoveUserPage();  // Open RemoveUserPage when clicked
            dispose();             // Close current page
        } else if (ae.getSource() == viewUsersButton) {
            // Redirect to View Users Page
            new ViewUserPage();  // Open ViewUsersPage when clicked
            dispose();            // Close current page
        } else if (ae.getSource() == updateUserButton) {
            // Redirect to Update User Page
            new UpdateUserPage();  // Open UpdateUserPage when clicked
            dispose();              // Close current page
        } else if (ae.getSource() == addMembershipButton) {
            // Redirect to Add Membership Page
            new AddMembershipPage();  // Open AddMembershipPage when clicked
            dispose();                 // Close current page
        } else if (ae.getSource() == updateMembershipButton) {
            // Redirect to Update Membership Page
            new UpdateMembershipPage();  // Open UpdateMembershipPage when clicked
            dispose();                    // Close current page
        } else if (ae.getSource() == backButton) {
            dispose();            // Close current page
            new AdminHomePage();  // Go back to Admin Home Page
        }
    }

    public static void main(String[] args) {
        new ManageUsersPage();
    }
}
