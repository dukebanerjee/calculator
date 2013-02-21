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
    public void showsZeroInitially() {
        calculator.shows("0");
    }

    @Test
    public void enterDigitsIntoDisplay() {
        calculator.pressInputKeys("1230.456789");
        calculator.shows("1230.456789");
    }

    @Test
    public void basicOperations() {
        calculator.press("6");
        calculator.press("*");
        calculator.shows("6");

        calculator.press("3");
        calculator.press("/");
        calculator.shows("18");

        calculator.press("2");
        calculator.press("-");
        calculator.shows("9");

        calculator.press("1");
        calculator.press("+");
        calculator.shows("8");

        calculator.press("4");
        calculator.press("=");
        calculator.shows("12");

        calculator.press("=");
        calculator.shows("16");

        calculator.press("=");
        calculator.shows("20");
    }
}
