package se.nackademin.gui;

import se.nackademin.FortuneTeller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FortuneTellerGui extends JFrame implements ActionListener {
    private static String NAME_LABEL = "Name:";
    private static String INCOME_LABEL = "Income (monthly):";
    private static String LOCATION_LABEL = "Location:";
    private static String AGE_LABEL = "Age:";
    private static String HEIGHT_LABEL = "Height:";
    private static String FORTUNE_LABEL = "Your fortune:";
    private static String BUTTON_TEXT = "Calculate";
    FortuneTeller fortuneTeller;
    JTextField nameField = new JTextField();
    JTextField incomeField = new JTextField();
    JTextField locationField = new JTextField();
    JTextField ageField = new JTextField();
    JTextField heightField = new JTextField();
    JTextArea resultField = new JTextArea();
    JButton calculateButton = new JButton(BUTTON_TEXT);
    JPanel mainPanel = new JPanel();

    public FortuneTellerGui(FortuneTeller fortuneTeller) {
        this.fortuneTeller = fortuneTeller;
        initialize();
    }

    private void initialize() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        mainPanel.setLayout(new GridLayout(13, 0));
        mainPanel.add(new JLabel(NAME_LABEL));
        mainPanel.add(nameField);
        mainPanel.add(new JLabel(INCOME_LABEL));
        mainPanel.add(incomeField);
        mainPanel.add(new JLabel(LOCATION_LABEL));
        mainPanel.add(locationField);
        mainPanel.add(new JLabel(AGE_LABEL));
        mainPanel.add(ageField);
        mainPanel.add(new JLabel(HEIGHT_LABEL));
        mainPanel.add(heightField);
        mainPanel.add(calculateButton);
        mainPanel.add(new JLabel(FORTUNE_LABEL));
        mainPanel.add(resultField);
        getContentPane().add(mainPanel);
        calculateButton.addActionListener(this);
    }

    private void alert(String message) {
        JOptionPane.showMessageDialog(this, message, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            boolean valid = true;
            if (!fortuneTeller.setName(nameField.getText())) {
                valid = false;
                alert("Invalid name!");
            } else if (!fortuneTeller.setIncome(incomeField.getText())) {
                valid = false;
                alert("Invalid income! Must not contain anything but numbers.");
            } else if (!fortuneTeller.setLocation(locationField.getText())) {
                valid = false;
                alert("Invalid location!");
            } else if (!fortuneTeller.setAge(ageField.getText())) {
                valid = false;
                alert("Invalid age! Must not contain anything but numbers.");
            } else if (!fortuneTeller.setHeight(heightField.getText())) {
                valid = false;
                alert("Invalid height! Must not contain anything but numbers.");
            }
            if (valid) {
                resultField.setText(fortuneTeller.calculate());
            }
        }
    }
}
