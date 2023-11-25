import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the main JFrame
            JFrame frame = new JFrame("Temperature Converter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation
            frame.setSize(500, 200); // Set frame size
            frame.setLayout(new FlowLayout()); // Use FlowLayout for layout

            // Select conversion method
            JLabel selectLabel = new JLabel("Select conversion method:");
            JComboBox<String> conversionMethods = new JComboBox<>(new String[]{"Celsius to Fahrenheit", "Fahrenheit to Celsius"});

            // Enter temperature
            JLabel inputLabel = new JLabel("Enter temperature:");
            JTextField temperatureField = new JTextField(10);

            // Convert button
            JButton convertButton = new JButton("Convert");

            // Result
            JLabel resultLabel = new JLabel("Result:");

            convertButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Get the selected conversion method and entered temperature
                        String selectedMethod = (String) conversionMethods.getSelectedItem();
                        double temperature = Double.parseDouble(temperatureField.getText());
                        double result = 0;

                        // Check the selected method and perform the appropriate conversion
                        if (selectedMethod.equals("Celsius to Fahrenheit")) {
                            result = (temperature * 9 / 5) + 32;
                            resultLabel.setText("Result in Fahrenheit: " + String.format("%.2f", result)); // Format to 2 decimal places
                        } else if (selectedMethod.equals("Fahrenheit to Celsius")) {
                            result = (temperature - 32) * 5 / 9;
                            resultLabel.setText("Result in Celsius: " + String.format("%.2f", result)); // Format to 2 decimal places
                        }
                    } catch (NumberFormatException ex) {
                        resultLabel.setText("Invalid input. Please enter a valid number.");
                    }
                }
            });

            // Adding components to the frame
            frame.add(selectLabel);
            frame.add(conversionMethods);
            frame.add(inputLabel);
            frame.add(temperatureField);
            frame.add(convertButton);
            frame.add(resultLabel);

            // Make the frame visible
            frame.setVisible(true);
        });
    }
}
