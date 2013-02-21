package examples.calculator.functional.ui;

import examples.calculator.ui.CalculatorUI;
import junit.framework.AssertionFailedError;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorDriver {
    private CalculatorUI ui;
    private final ComponentFinder finder;

    public CalculatorDriver() {
        syncUI(new Runnable() {
            @Override
            public void run() {
                ui = new CalculatorUI();
                ui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ui.setVisible(true);
            }
        });
        finder = new ComponentFinder(ui);
    }

    public void press(final String buttonLabel) {
        syncUI(new Runnable() {
            @Override
            public void run() {
                JButton button = finder.findComponentByLabel(JButton.class, buttonLabel);
                button.doClick();
            }
        });
    }

    public void shows(final String expectedDisplay) {
        syncUI(new Runnable() {
            @Override
            public void run() {
                JTextField display = finder.findComponentByLabel(JTextField.class, "display");
                assertThat(display.getText(), equalTo(expectedDisplay));
            }
        });
    }

    private void syncUI(Runnable action) {
        try {
            SwingUtilities.invokeAndWait(action);
        }
        catch (InvocationTargetException ex) {
            if(ex.getTargetException() instanceof RuntimeException) {
                throw (RuntimeException) ex.getTargetException();
            }
            else if(ex.getTargetException() instanceof Error) {
                throw (Error) ex.getTargetException();
            }
            else {
                throw new RuntimeException(ex.getTargetException());
            }
        }
        catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    public void pressInputKeys(String inputs) {
        for(char input : inputs.toCharArray()) {
            press(Character.toString(input));
        }
    }
}
