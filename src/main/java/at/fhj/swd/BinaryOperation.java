package at.fhj.swd;

import java.util.ArrayList;
import java.util.List;

public abstract class BinaryOperation extends UnaryOperation {
    private Expression operand2 = null;

    public List<Expression> getOperands() {
         List<Expression> operands = new ArrayList<Expression>();
         operands.add(getOperand());
         operands.add(operand2);
         return operands;
    }

    public BinaryOperation(Expression operand1, Expression operand2) {
        super(operand1);
        setSecondOperand(operand2);
    }

    public void setSecondOperand(Expression operand2) {
        if (operand2 == null)
            throw new IllegalArgumentException("Argument operand must not be null!");
        this.operand2 = operand2;
    }

    public Expression getSecondOperand() {
        return operand2;
    }

    public abstract float evaluate();
}
