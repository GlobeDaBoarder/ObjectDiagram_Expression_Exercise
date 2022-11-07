package at.fhj.swd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationInvertTest {

    Number zero = null;
    Number two = null;
    Number half = null;
    Number four = null;
    Number eight = null;
    Number fourth = null;
    Number eighth = null;

    Number minusZero = null;
    Number minusHalf = null;
    Number minusTwo = null;
    Invert invExpr = null;
    @BeforeEach
    void setUp(){
        eight = new Number(8F);
        four = new Number(4F);
        two = new Number(2F);
        half = new Number(0.5F);
        fourth = new Number(1/4F);
        eighth = new Number(1/8F);
        zero = new Number(0F);
        minusZero = new Number(-0F);
        minusHalf = new Number(-1/2F);
        minusTwo = new Number(-2F);
    }

    @Test
    void constructor() {
        // check Constructor must throw exception
        assertThrows(IllegalArgumentException.class, ()->{
            invExpr = new Invert(zero);
        });
        assertThrows(IllegalArgumentException.class, ()->{
            invExpr = new Invert(minusZero);
        });
    }

    @Test
    void evaluate() {
        invExpr = new Invert(minusTwo);
        assertEquals(minusHalf.evaluate(), invExpr.evaluate());

        invExpr = new Invert(eight);
        assertEquals(eighth.evaluate(), invExpr.evaluate());

    }

    @Test
    void evaluateWithComplexExpressions(){
        Add exprMinusFour = new Add(minusTwo, minusTwo);
        Add exprPlusFour = new Add(eight, exprMinusFour);
        invExpr = new Invert(exprPlusFour);
        assertEquals(fourth.evaluate(), invExpr.evaluate());
    }

    @Test
    void evaluateWithExpressionGettingZero(){
        Add exprTwoPotentiallyZero = new Add(four, minusTwo);
        invExpr = new Invert(exprTwoPotentiallyZero);
        assertEquals(half.evaluate(), invExpr.evaluate());
        // make it fail by making exprTwoPotentiallyZero to evaluate to 0.0F
        // would lead to a division by zero.
        exprTwoPotentiallyZero.setOperand(two);
        assertEquals(zero.evaluate(), exprTwoPotentiallyZero.evaluate());
        assertThrows(ArithmeticException.class, ()->{
            invExpr.evaluate();
        });

    }
}