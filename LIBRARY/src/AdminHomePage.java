import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminHomePage extends JFrame implements ActionListener {
    JLabel welcomeLabel;
    JButton manageBooksButton, manageUsersButton, viewReportsButton, logoutButton;

    public AdminHomePage() {
        setTitle("Admin Home Page");
        setLayout(null);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Welcome Label
        welcomeLabel = new JLabel("Welcome to the Admin Panel", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24));
        welcomeLabel.setBounds(50, 30, 500, 50);
        add(welcomeLabel);

        // Manage Books Button
        manageBooksButton = new JButton("Manage Books");
        manageBooksButton.setBounds(200, 100, 200, 40);
        manageBooksButton.addActionListener(this);
        add(manageBooksButton);

        // Manage Users Button
        manageUsersButton = new JButton("Manage Users");
        manageUsersButton.setBounds(200, 160, 200, 40);
        manageUsersButton.addActionListener(this);
        add(manageUsersButton);

        // View Reports Button
        viewReportsButton = new JButton("View Reports");
        viewReportsButton.setBounds(200, 220, 200, 40);
        viewReportsButton.addActionListener(this);
        add(viewReportsButton);

        // Logout Button
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(200, 280, 200, 40);
        logoutButton.addActionListener(this);
        add(logoutButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == manageBooksButton) {
            dispose();
            new ManageBooksPage(); // Redirect to Manage Books Page
        } else if (ae.getSource() == manageUsersButton) {
            dispose();
            new ManageUsersPage();
        } else if (ae.getSource() == viewReportsButton) {
            dispose();
            new ViewReportsPage();
        } else if (ae.getSource() == logoutButton) {
            JOptionPane.showMessageDialog(this, "Logging out...");
            dispose();
            new AdminLoginPage(); // Redirect to login page
        }
    }

    public static void main(String[] args) {
        new AdminHomePage();
    }
}
