import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ManageBooksPage extends JFrame implements ActionListener {
    // Buttons to navigate to respective pages
    JButton addBookButton, updateBookButton, deleteBookButton, viewBooksButton, bookIssueButton, bookReturnButton, backButton;

    public ManageBooksPage() {
        setTitle("Manage Books");
        setLayout(null);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add Book Button
        addBookButton = new JButton("Add Book");
        addBookButton.setBounds(200, 50, 200, 40);
        addBookButton.addActionListener(this);
        add(addBookButton);

        // Update Book Button
        updateBookButton = new JButton("Update Book");
        updateBookButton.setBounds(200, 110, 200, 40);
        updateBookButton.addActionListener(this);
        add(updateBookButton);

        // Delete Book Button
        deleteBookButton = new JButton("Delete Book");
        deleteBookButton.setBounds(200, 170, 200, 40);
        deleteBookButton.addActionListener(this);
        add(deleteBookButton);

        // View Books Button
        viewBooksButton = new JButton("View Books");
        viewBooksButton.setBounds(200, 230, 200, 40);
        viewBooksButton.addActionListener(this);
        add(viewBooksButton);

        // Book Issue Button
        bookIssueButton = new JButton("Issue Book");
        bookIssueButton.setBounds(200, 290, 200, 40);
        bookIssueButton.addActionListener(this);
        add(bookIssueButton);

        // Book Return Button
        bookReturnButton = new JButton("Return Book");
        bookReturnButton.setBounds(200, 350, 200, 40);
        bookReturnButton.addActionListener(this);
        add(bookReturnButton);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(200, 410, 200, 40);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addBookButton) {
            dispose();
            new AddBookPage(); // Redirect to Add Book Page
        } else if (ae.getSource() == updateBookButton) {
            dispose();
            new UpdateBookPage(); // Redirect to Update Book Page
        } else if (ae.getSource() == deleteBookButton) {
            dispose();
            new DeleteBookPage(); // Redirect to Delete Book Page
        } else if (ae.getSource() == viewBooksButton) {
            dispose();
            new ViewBooksPage(); // Redirect to View Books Page
        } else if (ae.getSource() == bookIssueButton) {
            dispose();
            new BookIssuePage(); // Redirect to Book Issue Page
        } else if (ae.getSource() == bookReturnButton) {
            dispose();
            new BookReturnPage(); // Redirect to Book Return Page
        } else if (ae.getSource() == backButton) {
            dispose();
            new AdminHomePage(); // Redirect to Admin Home Page
        }
    }

    public static void main(String[] args) {
        new ManageBooksPage();
    }
}
