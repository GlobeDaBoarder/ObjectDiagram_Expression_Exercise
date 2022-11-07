package at.fhj.swd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AllExpressionAndEvaluationTest {
    Expression rootExpr = null;

    @BeforeEach
    void setUp() {
        // here you must create the structure in such a way
        // to satisfy the tests.
        // DO NOT CHANGE ANY TESTS.
        rootExpr = new Subtract(
                new Invert(new Number(4F)),
                new Add(
                        new Invert(
                                new Add(
                                        new Number(3F),
                                        new Number(5F)
                                )
                        ),
                        new Negate(
                                new Invert(
                                        new Add(
                                                new Number(1F),
                                                new Number(3F)
                                        )
                                )
                        )
                )
        );
    }

    @Test
    void testRootExpression() {
        assertNotNull(rootExpr);
        assertTrue(rootExpr instanceof Subtract);
        assertEquals(3 / 8F, rootExpr.evaluate());
    }

    @Test
    void epxr1Test() {
        assertNotNull(rootExpr);
        assertTrue(rootExpr instanceof Subtract);
        assertNotNull(((Subtract) rootExpr).getOperand());
        assertTrue(((Subtract) rootExpr).getOperand() instanceof Invert);
        // expr1 check type and value
        Invert expr1 =(Invert)((Subtract) rootExpr).getOperand();
        assertTrue(expr1 instanceof Invert);
        assertEquals(1 / 4F, expr1.evaluate());
    }

    @Test
    void expr2Test(){
        assertNotNull(rootExpr);
        assertTrue(rootExpr instanceof Subtract);
        // expr2 check type and value
        assertNotNull(((Subtract) rootExpr).getSecondOperand());
        assertTrue(((Subtract) rootExpr).getSecondOperand() instanceof Add);
        Add expr2 = (Add) ((Subtract) rootExpr).getSecondOperand();
        assertNotNull(expr2);
        assertEquals(-1/8F, expr2.evaluate());
    }


    @Test
    void expr3Test(){
        assertNotNull(rootExpr);
        assertTrue(rootExpr instanceof Subtract);
        // expr2
        assertNotNull(((Subtract) rootExpr).getSecondOperand());
        assertTrue (((Subtract) rootExpr).getSecondOperand() instanceof Add);
        Add expr2 =  (Add)((Subtract) rootExpr).getSecondOperand();
        // expr3 check type and value
        assertTrue(expr2.getOperand() instanceof Invert);
        Invert expr3 = (Invert) expr2.getOperand();
        assertEquals(1/8F, expr3.evaluate());
    }

    @Test
    void expr4Test() {
        assertNotNull(rootExpr);
        assertTrue(rootExpr instanceof Subtract);
        // expr2
        assertNotNull(((Subtract) rootExpr).getSecondOperand());
        assertTrue (((Subtract) rootExpr).getSecondOperand() instanceof Add);
        Add expr2 =  (Add)((Subtract) rootExpr).getSecondOperand();
        // expr3
        assertNotNull(expr2.getOperand());
        assertTrue(expr2.getOperand() instanceof Invert);
        Invert expr3 = (Invert) expr2.getOperand();
        // expr4 check type and value
        assertTrue(expr3.getOperand() instanceof Add);
        Add expr4 = (Add) expr3.getOperand();
        assertEquals(8F, expr4.evaluate());
    }

    @Test
    void expr5Test() {
        assertNotNull(rootExpr);
        assertTrue(rootExpr instanceof Subtract);
        // expr2
        assertNotNull(((Subtract) rootExpr).getSecondOperand());
        assertTrue(((Subtract) rootExpr).getSecondOperand() instanceof Add);
        Add expr2 = (Add) ((Subtract) rootExpr).getSecondOperand();
        // type of expr 5 is correct
        assertNotNull(expr2.getSecondOperand());
        assertTrue(expr2.getSecondOperand() instanceof Negate);
        Negate expr5 = (Negate)expr2.getSecondOperand();
        assertEquals(-1/4F, expr5.evaluate());
    }

    @Test
    void expr6Test() {
        assertNotNull(rootExpr);
        assertTrue(rootExpr instanceof Subtract);
        // expr2
        assertNotNull(((Subtract) rootExpr).getSecondOperand());
        assertTrue(((Subtract) rootExpr).getSecondOperand() instanceof Add);
        Add expr2 = (Add) ((Subtract) rootExpr).getSecondOperand();
        // expr5
        assertNotNull(expr2.getSecondOperand());
        assertTrue(expr2.getSecondOperand() instanceof Negate);
        Negate expr5 = (Negate) expr2.getSecondOperand();
        // check type of expr6
        assertNotNull(expr5.getOperand());
        assertTrue(expr5.getOperand() instanceof Invert);
        Invert expr6 = (Invert) expr5.getOperand();
        assertEquals(1/4F, expr6.evaluate());
    }

    @Test
    void expr7Test() {
        assertNotNull(rootExpr);
        assertTrue(rootExpr instanceof Subtract);
        // expr2
        assertNotNull(((Subtract) rootExpr).getSecondOperand());
        assertTrue(((Subtract) rootExpr).getSecondOperand() instanceof Add);
        Add expr2 = (Add) ((Subtract) rootExpr).getSecondOperand();
        // expr5
        assertNotNull(expr2.getSecondOperand());
        assertTrue(expr2.getSecondOperand() instanceof Negate);
        Negate expr5 = (Negate) expr2.getSecondOperand();
        // check type of expr6
        assertNotNull(expr5.getOperand());
        assertTrue(expr5.getOperand() instanceof Invert);
        Invert expr6 = (Invert) expr5.getOperand();
        // check type of expr 7
        assertNotNull(expr6.getOperand());
        assertTrue(expr6.getOperand() instanceof Add);
        Add expr7 = (Add) expr6.getOperand();
        assertEquals(4F, expr7.evaluate());
    }

}
