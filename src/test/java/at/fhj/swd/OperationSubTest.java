package at.fhj.swd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationSubTest {
    Number num1 = null;
    Number num2 = null;
    Subtract opSub = null;


    @BeforeEach
    public void setUp() {
        num1 = new Number(23);
        num2 = new Number(9);
        opSub = new Subtract(num1, num2);
    }

    @Test
    public void getOperandsTest() {
        List<Expression> operands = opSub.getOperands();
        assertEquals(2, operands.size());
        assertEquals(num1, opSub.getOperands().get(0));
        assertEquals(num2, opSub.getOperands().get(1));
    }

    @Test
    public void setOperands() {
        Number num3 = new Number(21);
        List<Expression> operands = opSub.getOperands();
        assertEquals(2, operands.size());
        assertEquals(num1, operands.get(0));
        assertEquals(num2, operands.get(1));

        opSub.setOperand(num3);
        operands = opSub.getOperands();
        assertEquals(num3, operands.get(0));

        opSub.setSecondOperand(num3);
        operands = opSub.getOperands();
        assertEquals(num3, operands.get(1));

    }

    @Test
    public void evaluateSimpleTest() {
        float difference = num1.getValue()-num2.getValue();
        assertEquals(difference, opSub.evaluate());
    }

    @Test
    public void evaluateWithNestedExpression(){
        float difference = num1.getValue()-(num1.getValue()-num2.getValue());
        Subtract operationSub2 = new Subtract(num1, opSub);
        assertEquals(difference, operationSub2.evaluate());

        operationSub2.setOperand(opSub);
        assertEquals(0, operationSub2.evaluate(), 0.000001);
    }
}