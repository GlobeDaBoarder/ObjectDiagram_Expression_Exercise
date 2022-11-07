package at.fhj.swd;

public class Add extends BinaryOperation {

    public Add(Expression summand1, Expression summand2){
        super(summand1,summand2);
    }

    public float evaluate() {
        float sum = Float.valueOf(0f);
        for(Expression expression: getOperands()){
            sum += expression.evaluate();
        }

        return sum;
    }
}
