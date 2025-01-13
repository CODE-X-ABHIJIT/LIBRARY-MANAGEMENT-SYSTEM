import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateBookPage extends JFrame implements ActionListener {
    JLabel bookIdLabel, bookNameLabel, authorLabel;
    JTextField bookIdField, bookNameField, authorField;
    JButton updateButton, backButton;

    public UpdateBookPage() {
        setTitle("Update Book");
        setLayout(null);
        setSize(400, 300);
        setLocationRelativeTo(null);

        bookIdLabel = new JLabel("Book ID:");
        bookIdLabel.setBounds(50, 50, 100, 30);
        add(bookIdLabel);

        bookIdField = new JTextField();
        bookIdField.setBounds(150, 50, 200, 30);
        add(bookIdField);

        bookNameLabel = new JLabel("Book Name:");
        bookNameLabel.setBounds(50, 100, 100, 30);
        add(bookNameLabel);

        bookNameField = new JTextField();
        bookNameField.setBounds(150, 100, 200, 30);
        add(bookNameField);

        authorLabel = new JLabel("Author:");
        authorLabel.setBounds(50, 150, 100, 30);
        add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(150, 150, 200, 30);
        add(authorField);

        updateButton = new JButton("Update");
        updateButton.setBounds(50, 200, 100, 30);
        updateButton.addActionListener(this);
        add(updateButton);

        backButton = new JButton("Back");
        backButton.setBounds(200, 200, 100, 30);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == updateButton) {
            // Logic to update the book (placeholder)
            JOptionPane.showMessageDialog(this, "Book Updated Successfully!");
        } else if (ae.getSource() == backButton) {
            dispose();
            new ManageBooksPage();
        }
    }

    public static void main(String[] args) {
        new UpdateBookPage();
    }
}
