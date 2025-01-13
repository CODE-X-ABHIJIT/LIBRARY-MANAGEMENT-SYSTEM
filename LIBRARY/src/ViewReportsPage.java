import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewReportsPage extends JFrame implements ActionListener {
    JButton viewBooksReportButton, viewUsersReportButton, backButton;
    JTable reportTable;
    JScrollPane scrollPane;

    public ViewReportsPage() {
        setTitle("View Report");
        setLayout(null);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // View Books Report Button
        viewBooksReportButton = new JButton("View Books Report");
        viewBooksReportButton.setBounds(50, 50, 200, 40);
        viewBooksReportButton.addActionListener(this);
        add(viewBooksReportButton);

        // View Users Report Button
        viewUsersReportButton = new JButton("View Users Report");
        viewUsersReportButton.setBounds(300, 50, 200, 40);
        viewUsersReportButton.addActionListener(this);
        add(viewUsersReportButton);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(550, 50, 200, 40);
        backButton.addActionListener(this);
        add(backButton);

        // Report Table (empty initially)
        reportTable = new JTable();
        scrollPane = new JScrollPane(reportTable);
        scrollPane.setBounds(50, 120, 700, 300);
        add(scrollPane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == viewBooksReportButton) {
            // Show Books Report
            String[] columnNames = {"Book ID", "Title", "Author", "Genre", "Status"};
            Object[][] data = {
                    {"B001", "Java Programming", "John Smith", "Programming", "Available"},
                    {"B002", "Database Management", "Jane Doe", "Computer Science", "Issued"},
                    {"B003", "Data Structures", "Alan Turing", "Computer Science", "Available"}
            };
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            reportTable.setModel(model);
        } else if (ae.getSource() == viewUsersReportButton) {
            // Show Users Report
            String[] columnNames = {"User ID", "Name", "Email", "Membership Status"};
            Object[][] data = {
                    {"U001", "John Doe", "john@example.com", "Active"},
                    {"U002", "Jane Smith", "jane@example.com", "Inactive"},
                    {"U003", "Alice Johnson", "alice@example.com", "Active"}
            };
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            reportTable.setModel(model);
        } else if (ae.getSource() == backButton) {
            dispose();
            new AdminHomePage(); // Go back to Admin Home Page
        }
    }

    public static void main(String[] args) {
        new ViewReportsPage();
    }
}
