import javax.swing.*;
import java.awt.*;

public class FinePayPage extends JFrame {
    JLabel fineAmountLabel, remarksLabel;
    JTextArea remarksTextArea;
    JButton confirmButton;

    public FinePayPage(double fineAmount) {
        setTitle("Fine Pay");
        setLayout(null);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Fine Amount Label
        fineAmountLabel = new JLabel("Fine to Pay: ₹" + fineAmount);
        fineAmountLabel.setBounds(50, 50, 300, 30);
        add(fineAmountLabel);

        // Remarks Label
        remarksLabel = new JLabel("Remarks (Optional):");
        remarksLabel.setBounds(50, 100, 150, 30);
        add(remarksLabel);

        // Remarks TextArea
        remarksTextArea = new JTextArea();
        remarksTextArea.setBounds(50, 130, 300, 80);
        add(remarksTextArea);

        // Confirm Button
        confirmButton = new JButton("Confirm Payment");
        confirmButton.setBounds(100, 220, 200, 40);
        add(confirmButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new FinePayPage(20.0); // Test with a sample fine amount
    }
}
