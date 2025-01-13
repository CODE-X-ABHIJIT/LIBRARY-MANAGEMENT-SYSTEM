import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddBookPage extends JFrame implements ActionListener {
    JTextField bookNameField, authorField;
    JButton submitButton, backButton;
    JRadioButton bookRadioButton, movieRadioButton;

    public AddBookPage() {
        setTitle("Add Book");
        setLayout(null);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Book name field
        JLabel bookNameLabel = new JLabel("Book Name:");
        bookNameLabel.setBounds(50, 50, 100, 30);
        add(bookNameLabel);
        bookNameField = new JTextField();
        bookNameField.setBounds(150, 50, 200, 30);
        add(bookNameField);

        // Author name field
        JLabel authorLabel = new JLabel("Author Name:");
        authorLabel.setBounds(50, 100, 100, 30);
        add(authorLabel);
        authorField = new JTextField();
        authorField.setBounds(150, 100, 200, 30);
        add(authorField);

        // Radio buttons for book or movie
        bookRadioButton = new JRadioButton("Book");
        bookRadioButton.setBounds(50, 150, 100, 30);
        movieRadioButton = new JRadioButton("Movie");
        movieRadioButton.setBounds(150, 150, 100, 30);
        ButtonGroup group = new ButtonGroup();
        group.add(bookRadioButton);
        group.add(movieRadioButton);
        add(bookRadioButton);
        add(movieRadioButton);

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.setBounds(50, 200, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        // Back button
        backButton = new JButton("Back");
        backButton.setBounds(200, 200, 100, 30);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitButton) {
            // Validation before submitting the form
            String bookName = bookNameField.getText();
            String author = authorField.getText();
            if (bookName.isEmpty() || author.isEmpty() || !(bookRadioButton.isSelected() || movieRadioButton.isSelected())) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields and select book type.");
            } else {
                JOptionPane.showMessageDialog(this, "Book Added Successfully!");
            }
        } else if (ae.getSource() == backButton) {
            dispose();
            new ManageBooksPage(); // Go back to Manage Books Page
        }
    }

    public static void main(String[] args) {
        new AddBookPage();
    }
}
