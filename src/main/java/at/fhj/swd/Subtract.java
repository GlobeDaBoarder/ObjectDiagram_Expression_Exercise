package at.fhj.swd;

public class Subtract extends BinaryOperation {

    public Subtract(Expression minuend, Expression subtrahend){
        super(minuend, subtrahend);
    }

    @Override
    public float evaluate() {
        float difference = getOperand().evaluate();
       difference -= getSecondOperand().evaluate();
        return difference;
    }
}
