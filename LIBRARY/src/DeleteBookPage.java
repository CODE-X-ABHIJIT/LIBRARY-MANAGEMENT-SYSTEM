import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteBookPage extends JFrame implements ActionListener {
    JLabel bookIdLabel;
    JTextField bookIdField;
    JButton deleteButton, backButton;

    public DeleteBookPage() {
        setTitle("Delete Book");
        setLayout(null);
        setSize(400, 200);
        setLocationRelativeTo(null);

        bookIdLabel = new JLabel("Book ID:");
        bookIdLabel.setBounds(50, 50, 100, 30);
        add(bookIdLabel);

        bookIdField = new JTextField();
        bookIdField.setBounds(150, 50, 200, 30);
        add(bookIdField);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(50, 100, 100, 30);
        deleteButton.addActionListener(this);
        add(deleteButton);

        backButton = new JButton("Back");
        backButton.setBounds(200, 100, 100, 30);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deleteButton) {
            // Logic to delete the book (placeholder)
            JOptionPane.showMessageDialog(this, "Book Deleted Successfully!");
        } else if (ae.getSource() == backButton) {
            dispose();
            new ManageBooksPage();
        }
    }

    public static void main(String[] args) {
        new DeleteBookPage();
    }
}
