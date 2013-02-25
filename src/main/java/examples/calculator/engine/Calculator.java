package examples.calculator.engine;

import java.math.BigDecimal;

public class Calculator {
    private BigDecimal value;
    private BigDecimal operand;
    private Operation lastOperation;
    private BigDecimal equalsOperand;
    private Operation equalsOperation;

    public Operation Addition = new Operation() {
        @Override
        public BigDecimal apply(BigDecimal rhs, BigDecimal lhs) {
            return rhs.add(lhs);
        }
    };

    public Operation Subtraction = new Operation() {
        @Override
        public BigDecimal apply(BigDecimal rhs, BigDecimal lhs) {
            return rhs.subtract(lhs);
        }
    };

    public Operation Multiplication = new Operation() {
        @Override
        public BigDecimal apply(BigDecimal rhs, BigDecimal lhs) {
            return rhs.multiply(lhs);
        }
    };
    public Operation Divide = new Operation() {
        @Override
        public BigDecimal apply(BigDecimal rhs, BigDecimal lhs) {
            return rhs.divide(lhs);
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
        if(lastOperation != null) {
            this.value = lastOperation.apply(operand, value);
        }
        this.lastOperation = currentOperation;
    }

    public void equals() {
        if(equalsOperation == null) {
            equalsOperation = lastOperation;
            equalsOperand = value;
            this.value = lastOperation.apply(operand, value);
        } else {
            this.value = equalsOperation.apply(value, equalsOperand);
        }
    }
}
