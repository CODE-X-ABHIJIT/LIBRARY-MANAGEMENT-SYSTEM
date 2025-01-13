import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BookIssuePage extends JFrame implements ActionListener {
    JTextField bookNameField;
    JComboBox<String> bookList;
    JButton submitButton, backButton;

    public BookIssuePage() {
        setTitle("Book Issue");
        setLayout(null);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel bookNameLabel = new JLabel("Book Name:");
        bookNameLabel.setBounds(50, 50, 100, 30);
        add(bookNameLabel);

        bookNameField = new JTextField();
        bookNameField.setBounds(150, 50, 200, 30);
        add(bookNameField);

        // Submit Button
        submitButton = new JButton("Issue Book");
        submitButton.setBounds(50, 200, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(200, 200, 100, 30);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitButton) {
            String bookName = bookNameField.getText();
            JOptionPane.showMessageDialog(this, "Book " + bookName + " has been issued successfully.");
        } else if (ae.getSource() == backButton) {
            dispose();
            new ManageBooksPage(); // Go back to Admin Home Page
        }
    }

    public static void main(String[] args) {
        new BookIssuePage();
    }
}
