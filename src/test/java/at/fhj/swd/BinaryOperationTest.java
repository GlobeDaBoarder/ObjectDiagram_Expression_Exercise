package at.fhj.swd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryOperationTest {
    BinaryOperation binaryOperation = null;
    Number num1;
    Number num2;
    @BeforeEach
    public void setUp(){
        num1 = new Number(23);
        num2 = new Number(13);
        binaryOperation = new Add(num1,num2);
    }

    @Test
    void getOperands() {
        List<Expression> list = List.of(num1, num2);
        assertEquals(list, binaryOperation.getOperands());
    }

    @Test
    void setSecondOperand() {
        Number num3 = new Number(345);
        binaryOperation.setSecondOperand(num3);
        assertEquals(num3, binaryOperation.getSecondOperand());
    }

    @Test
    void getSecondOperand() {
        assertEquals(num2, binaryOperation.getSecondOperand());
    }
}