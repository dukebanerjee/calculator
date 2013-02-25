package examples.calculator.unit.engine;

import examples.calculator.engine.Calculator;
import org.junit.Before;
import org.junit.Test;

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
        calculator.setValue(3);
        calculator.setOperation(Calculator.Addition);
        assertThat(calculator.getValue(), equalTo(3));
    }

    @Test
    public void shouldEvaluateOperationWhenEqualsIsPressed() {
        calculator.setValue(3);
        calculator.setOperation(Calculator.Addition);
        calculator.setValue(2);
        calculator.setOperation(Calculator.Equals);
        assertThat(calculator.getValue(), equalTo(5));
    }

    @Test
    public void shouldEvaluateOperationWhenAnotherOperationIsPressed() {
        calculator.setValue(3);
        calculator.setOperation(Calculator.Addition);
        calculator.setValue(2);
        calculator.setOperation(Calculator.Addition);
        assertThat(calculator.getValue(), equalTo(5));
    }
}
