package at.fhj.swd;

public class Invert extends UnaryOperation {

    public Invert(Expression operand){
        super(operand);
        if (getOperand().evaluate() == 0)
            throw new IllegalArgumentException("can't be 0");
    }

    @Override
    public float evaluate() {
        if (getOperand().evaluate() == 0.0f)
            throw new ArithmeticException("can't invert because 0");

        return 1/ getOperand().evaluate();
    }
}
