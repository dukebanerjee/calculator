package examples.calculator.functional.ui;

import org.junit.Test;
import org.junit.Before;

public class CalculatorEndToEndTest {
    private CalculatorDriver calculator;

    @Before
    public void setup() {
        calculator = new CalculatorDriver();
    }

    @Test
    public void shouldShowZeroInitially() {
        calculator.shows("0");
    }

    @Test
    public void shouldEnterDigitsIntoDisplay() {
        calculator.press("1");
        calculator.press("2");
        calculator.press("3");
        calculator.press("0");
        calculator.press(".");
        calculator.press("4");
        calculator.press("5");
        calculator.press("6");
        calculator.press("7");
        calculator.press("8");
        calculator.press("9");

        calculator.shows("1230.456789");
    }
}
