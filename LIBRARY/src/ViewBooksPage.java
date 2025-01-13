import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class ViewBooksPage extends JFrame implements ActionListener {

    JLabel searchLabel;
    JTextField searchTextField;
    JComboBox<String> searchDropdown;
    JButton searchButton, backButton;
    JTable booksTable;
    DefaultTableModel tableModel;

    public ViewBooksPage() {
        setTitle("View Books");
        setLayout(null);
        setSize(800, 500);
        setLocationRelativeTo(null);

        // Search Text Field
        searchLabel = new JLabel("Search by:");
        searchLabel.setBounds(50, 50, 100, 30);
        add(searchLabel);

        searchTextField = new JTextField();
        searchTextField.setBounds(150, 50, 150, 30);
        add(searchTextField);

        // Search Dropdown
        searchDropdown = new JComboBox<>(new String[] { "Select Search Type", "Book Name", "Author Name" });
        searchDropdown.setBounds(320, 50, 150, 30);
        add(searchDropdown);

        // Search Button
        searchButton = new JButton("Search");
        searchButton.setBounds(500, 50, 100, 30);
        searchButton.addActionListener(this);
        add(searchButton);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(620, 50, 100, 30);
        backButton.addActionListener(this);
        add(backButton);

        // Table for Search Results
        String[] columnNames = { "Book Name", "Author Name", "Select" };
        tableModel = new DefaultTableModel(null, columnNames);
        booksTable = new JTable(tableModel) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) { // Last column (Select column)
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        booksTable.setBounds(50, 100, 700, 300);
        booksTable.setFillsViewportHeight(true);
        booksTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(booksTable);
        scrollPane.setBounds(50, 100, 700, 300);
        add(scrollPane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchButton) {
            // Validate input before performing search
            String searchText = searchTextField.getText().trim();
            String searchType = (String) searchDropdown.getSelectedItem();

            if ((searchText.isEmpty() && searchType.equals("Select Search Type")) || searchType == null) {
                JOptionPane.showMessageDialog(this, "Please fill in a valid search type or search text.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // If valid, proceed with the search (Just simulating search results here)
            performSearch(searchText, searchType);
        } else if (ae.getSource() == backButton) {
            dispose();
            new ManageBooksPage(); // Go back to Admin Home Page
        }
    }

    // Simulating search results
    private void performSearch(String searchText, String searchType) {
        // For now, this will just add some dummy data to simulate a search result.
        // In a real application, you'd query the database and display relevant results.

        // Clear previous results
        tableModel.setRowCount(0);

        // Simulating 3 book entries
        Object[][] books = {
                { "Java Programming", "John Doe", Boolean.FALSE },
                { "Data Structures", "Jane Smith", Boolean.FALSE },
                { "Algorithms", "Alan Turing", Boolean.FALSE }
        };

        for (Object[] book : books) {
            tableModel.addRow(book);
        }
    }

    public static void main(String[] args) {
        new ViewBooksPage();
    }
}
