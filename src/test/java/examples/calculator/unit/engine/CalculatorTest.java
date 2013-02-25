package examples.calculator.unit.engine;

import examples.calculator.engine.Calculator;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void shouldReturnEnteredValueWhenFirstOperatorIsPressed() {
        calculator.setValue(new BigDecimal(3));
        calculator.setOperation(calculator.Addition);
        assertThat(calculator.getValue(), equalTo(new BigDecimal(3)));
    }

    @Test
    public void shouldEvaluateOperationWhenEqualsIsPressed() {
        calculator.setValue(new BigDecimal(3));
        calculator.setOperation(calculator.Addition);
        calculator.setValue(new BigDecimal(2));
        calculator.setOperation(calculator.Equals);
        assertThat(calculator.getValue(), equalTo(new BigDecimal(5)));
    }

    @Test
    public void shouldEvaluateOperationWhenAnotherOperationIsPressed() {
        calculator.setValue(new BigDecimal(3));
        calculator.setOperation(calculator.Addition);
        calculator.setValue(new BigDecimal(2));
        calculator.setOperation(calculator.Addition);
        assertThat(calculator.getValue(), equalTo(new BigDecimal(5)));
    }

    @Test
    public void shouldEvaluateSubtraction() {
        calculator.setValue(new BigDecimal(3));
        calculator.setOperation(calculator.Subtraction);
        calculator.setValue(new BigDecimal(2));
        calculator.setOperation(calculator.Equals);
        assertThat(calculator.getValue(), equalTo(new BigDecimal(1)));
    }

    @Test
    public void shouldEvaluateMultiplication() {
        calculator.setValue(new BigDecimal(3));
        calculator.setOperation(calculator.Multiplication);
        calculator.setValue(new BigDecimal(2));
        calculator.setOperation(calculator.Equals);
        assertThat(calculator.getValue(), equalTo(new BigDecimal(6)));
    }

    @Test
    public void shouldEvaluateDivision() {
        calculator.setValue(new BigDecimal(6));
        calculator.setOperation(calculator.Divide);
        calculator.setValue(new BigDecimal(2));
        calculator.setOperation(calculator.Equals);
        assertThat(calculator.getValue(), equalTo(new BigDecimal(3)));
    }
}
