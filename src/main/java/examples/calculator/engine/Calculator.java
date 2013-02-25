package examples.calculator.engine;

public class Calculator {
    private int value;
    private int operand;
    private Object operation;

    public static Object Addition = new Object();
    public static Object Equals = new Object();
    public static Object Subtraction = new Object();

    public void setValue(int value) {
        this.operand = this.value;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setOperation(Object operation) {
        if(operation == Equals) {
            if(this.operation == Addition) {
                this.value = this.operand + this.value;
            }
            else if(this.operation == Subtraction) {
                this.value = this.operand - this.value;
            }
        } else if(operation == Addition) {
            this.value = this.operand + this.value;
        }
        this.operation = operation;
    }
}
