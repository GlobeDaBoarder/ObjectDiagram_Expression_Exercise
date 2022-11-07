package at.fhj.swd;

public abstract class UnaryOperation implements Expression{
    private Expression operand = null;



    public Expression getOperand() {
        return operand;
    }

    public UnaryOperation(Expression operand){
        setOperand(operand);
    }

    public void setOperand(Expression operand){
        if(operand == null) throw new IllegalArgumentException("Argument 'operand' must not be null!");
        this.operand = operand;
    }

    public abstract float evaluate();

}
