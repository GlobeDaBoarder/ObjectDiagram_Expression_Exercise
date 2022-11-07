package at.fhj.swd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnaryOperationTest {
    UnaryOperation operation;
    @BeforeEach
    public void setUp(){
        operation = new Negate(new Number(13));
    }

    @Test
    public void getOperand() {
        Expression expr = operation.getOperand();
        assertNotNull(expr);
        assertEquals(13, expr.evaluate());
        assertEquals(-13, operation.evaluate());
    }
}