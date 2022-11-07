package at.fhj.swd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OperationAddTest {
    BinaryOperation opAdd = null;
    Number num1;
    Number num2;

    @BeforeEach
    public void setUp(){
        num1 = new Number(21);
        num2 = new Number(13);
        opAdd = new Add(num1,num2);
    }

    @Test
    public void constructorWithFirstNullArgumentTest(){
        assertThrows(IllegalArgumentException.class, ()->{
            new Add(null, num2);
        });
    }

    @Test
    public void constructorWithSecondNullArgumentTest(){
        assertThrows(IllegalArgumentException.class, ()->{
            new Add(num1, null);
        });
    }

    @Test
    public void getFirstOperandTest(){
        Expression operand = opAdd.getOperand();
        assertNotNull(operand);
        assertEquals(num1,operand);
    }

    @Test
    public void getSecondOperandTest(){
        Expression operand = opAdd.getSecondOperand();
        assertNotNull(operand);
        assertEquals(num2,operand);
    }

    @Test
    public void getOperandsTest(){
        List<Expression> operands = opAdd.getOperands();
        assertNotNull(operands);
        assertEquals(2, operands.size());
        assertEquals(num1, operands.get(0));
        assertEquals(num2, operands.get(1));
    }

    @Test
    public void setFirstOperandToNullTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            opAdd.setOperand(null);
        });
    }

    @Test
    public void setSecondOperandToNullTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            opAdd.setSecondOperand(null);
        });
    }


    @Test
    public void setFirstOperandTest(){
        Number num3 = new Number(9);
        List<Expression> operands = opAdd.getOperands();
        assertFalse(operands.contains(num3));

        opAdd.setOperand(num3);
        operands = opAdd.getOperands();
        assertTrue(operands.contains(num3));
        assertEquals(num3, operands.get(0));
    }

    @Test
    public void setSecondOperandTest(){
        Number num3 = new Number(9);
        List<Expression> operands = opAdd.getOperands();
        assertFalse(operands.contains(num3));

        opAdd.setSecondOperand(num3);
        operands = opAdd.getOperands();
        assertTrue(operands.contains(num3));
        assertEquals(num3, operands.get(1));
    }

    // num1 + num2
    @Test
    public void evaluateTest(){
        float sum = num1.getValue();
        sum += num2.getValue();
        assertEquals(sum, opAdd.evaluate());
    }

    // num1 + (num1+num2)
    @Test
    public void evaluateNestedExpressionsTest(){
        float sum = 2*(num1.getValue());
        Add opAddExtended = new Add(num1, opAdd);
        sum+= num2.getValue();
        assertEquals(sum, opAddExtended.evaluate());
    }


}