package examples.calculator.engine;

import java.math.BigDecimal;

public class Calculator {
    private BigDecimal value;
    private BigDecimal operand;
    private Operation lastOperation;

    public Operation Equals = new Operation() {
        @Override
        public BigDecimal apply(BigDecimal operand, BigDecimal value) {
            return lastOperation.apply(operand, value);
        }
    };

    public Operation Addition = new Operation() {
        @Override
        public BigDecimal apply(BigDecimal operand, BigDecimal value) {
            return operand.add(value);
        }
    };

    public Operation Subtraction = new Operation() {
        @Override
        public BigDecimal apply(BigDecimal operand, BigDecimal value) {
            return operand.subtract(value);
        }
    };

    public Operation Multiplication = new Operation() {
        @Override
        public BigDecimal apply(BigDecimal operand, BigDecimal value) {
            return operand.multiply(value);
        }
    };

    public Operation Divide = new Operation() {
        @Override
        public BigDecimal apply(BigDecimal operand, BigDecimal value) {
            return operand.divide(value);
        }
    };

    public void setValue(BigDecimal value) {
        this.operand = this.value;
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setOperation(Operation currentOperation) {
        if(currentOperation == Equals || lastOperation != null) {
            this.value = lastOperation.apply(operand, value);
        }
        this.lastOperation = currentOperation;
    }
}
