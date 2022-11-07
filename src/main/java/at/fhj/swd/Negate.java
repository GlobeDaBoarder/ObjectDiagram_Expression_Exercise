package at.fhj.swd;

public class Negate extends UnaryOperation {


    public Negate(Expression operand) {
       super(operand);
    }

    public boolean isPositive() {
        return  1 / evaluate() > 0;
    }


    public boolean isNegative() {
        return  1 / evaluate() < 0;
    }


    @Override
    public float evaluate() {
        return getOperand().evaluate() * (-1);
    }
}
