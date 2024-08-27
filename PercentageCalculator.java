import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PercentageCalculator extends JFrame implements ActionListener {
    private JTextField input1Field;
    private JTextField input2Field;
    private JTextField resultField;
    private JComboBox<String> operationBox;
    private JButton calculateButton;
    
    public PercentageCalculator() {
        // Set up the frame
        setTitle("Percentage Calculator");
        setSize(845, 570);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create UI components
        JLabel name1Label = new JLabel("Intern Aswathi");
        setLayout(new FlowLayout());
        JLabel input1Label = new JLabel("Input Value 1:");
        
        JLabel input2Label = new JLabel("Input Value 2/(total):");
        JLabel resultLabel = new JLabel("Result (in %):");
        
        input1Field = new JTextField(5);
                // input1Field.setBounds(10, 20, 80, 25);

        input2Field = new JTextField(5);
        resultField = new JTextField(5);
        resultField.setEditable(false);
        
        String[] operations = { /* "Find Whole"*/ "Percentage", "Percentage Increase", "Percentage Decrease", };
        operationBox = new JComboBox<>(operations);
        
        calculateButton = new JButton("Calculate %");
        JLabel dicription31Label = new JLabel("DISCRIPTION:");
        JLabel dicription1Label = new JLabel("PERCENTAGE percentage is a number or ratio that can be expressed as a fraction of 100.");
        JLabel dicription2Label = new JLabel("PERCENATGE INCREASE means divide the difference by the original price and multiply it by 100.");
        JLabel dicriptionLabel = new JLabel("PERCENTAGE DECREASE decrease calculator determines the change from one amount to a lesser amount in terms of percent decrease.");
        calculateButton.addActionListener(this);
        
        // Arrange components in a panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(30, 10, 6,10 ));

        panel.add(name1Label);
        panel.add(input1Label);
        panel.add(input1Field);
        panel.add(input2Label);
        panel.add(input2Field);
        panel.add(new JLabel("Operation:"));
        panel.add(operationBox);
        panel.add(resultLabel);
        panel.add(resultField);
        panel.add(calculateButton);
        panel.add(dicription31Label);
        
        panel.add(dicription1Label);
        panel.add(dicription2Label);
        panel.add(dicriptionLabel);
        

       

        // Add panel to frame
        add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double input1 = Double.parseDouble(input1Field.getText());
            double input2 = Double.parseDouble(input2Field.getText());
            String operation = (String) operationBox.getSelectedItem();
            double result = 0;

            switch (operation) {
                
                case "Percentage":
                    result = (input1 * 100) / input2 ;
                    break;
                case "Percentage Increase":
                    result = input1 + (input1 * input2 / 100);
                    break;
                case "Percentage Decrease":
                    result = input1 - (input1 * input2 / 100);
                    break;
                
            }
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PercentageCalculator calculator = new PercentageCalculator();
            calculator.setVisible(true);
        });
    }
}