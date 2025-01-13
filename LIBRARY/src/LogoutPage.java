import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LogoutPage extends JFrame implements ActionListener {
    JButton logoutButton, cancelButton;

    public LogoutPage() {
        setTitle("Logout");
        setLayout(null);
        setSize(400, 200);
        setLocationRelativeTo(null);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(50, 50, 100, 30);
        logoutButton.addActionListener(this);
        add(logoutButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 50, 100, 30);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == logoutButton) {
            JOptionPane.showMessageDialog(this, "Logging out...");
            dispose();
            new AdminLoginPage(); // Go back to Admin Login Page
        } else if (ae.getSource() == cancelButton) {
            dispose();
            new AdminHomePage(); // Cancel logout and return to Admin Home Page
        }
    }

    public static void main(String[] args) {
        new LogoutPage();
    }
}
