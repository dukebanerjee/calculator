package examples.calculator.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI extends JFrame {
    private JTextField display;

    public CalculatorUI() {
        super("Calculator");

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridy = 0;
        c.gridwidth = 3;
        add(display(), c);
        c.gridwidth = 1;

        c.fill = GridBagConstraints.BOTH;

        c.gridy++;
        c.gridx = 0;
        add(inputButton("7"), c);
        c.gridx++;
        add(inputButton("8"), c);
        c.gridx++;
        add(inputButton("9"), c);

        c.gridy++;
        c.gridx = 0;
        add(inputButton("4"), c);
        c.gridx++;
        add(inputButton("5"), c);
        c.gridx++;
        add(inputButton("6"), c);

        c.gridy++;
        c.gridx = 0;
        add(inputButton("1"), c);
        c.gridx++;
        add(inputButton("2"), c);
        c.gridx++;
        add(inputButton("3"), c);

        c.gridy++;
        c.gridx = 0;
        c.gridwidth = 2;
        add(inputButton("0"), c);
        c.gridx += 2;
        c.gridwidth = 1;
        add(inputButton("."), c);

        pack();
    }

    private JTextField display() {
        display = new JTextField();
        display.setName("display");
        display.setText("0");
        return display;
    }

    private JButton inputButton(final String label) {
        JButton button = new JButton(label);
        button.setName(label);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prev = display.getText();
                display.setText(prev.equals("0") ? label : prev + label);
            }
        });
        return button;
    }
}
