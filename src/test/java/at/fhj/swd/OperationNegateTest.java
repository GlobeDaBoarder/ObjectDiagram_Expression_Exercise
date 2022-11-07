package at.fhj.swd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationNegateTest {
    Number zero = null;
    Number minusZero = null;
    Number twentyThree = null;
    Number minusThirteen = null;

    Negate negateExpr = null;

    @BeforeEach
    void setUp() {
        zero = new Number(0F);
        minusZero = new Number(-0F);
        twentyThree = new Number(23F);
        minusThirteen = new Number(-13F);
        negateExpr = new Negate(zero);
    }

    @Test
    void borderCaseWithPositiveZero() {
        // initialized with a positive 'zero', a 0.0F
        // negation of 0.0 must be -0.0 with floats and doubles
        assertNotEquals(negateExpr.isNegative(), negateExpr.isPositive());
        assertTrue(negateExpr.isNegative());
        assertFalse(negateExpr.isPositive());

        assertNotEquals(negateExpr.evaluate(), zero.evaluate());
        assertEquals(-0.0F, negateExpr.evaluate());
    }

    @Test
    void borderCasewithNegativeZero() {
        // initialized with a negative 'zero', a -0.0F
        negateExpr = new Negate(minusZero);
        // negation of -0.0 must be 0.0 with floats and doubles
        assertNotEquals(negateExpr.isNegative(), negateExpr.isPositive());
        assertFalse(negateExpr.isNegative());
        assertTrue(negateExpr.isPositive());

        assertNotEquals(negateExpr.evaluate(), minusZero.evaluate());
        assertEquals(0.0F, negateExpr.evaluate());

    }

    @Test
    void withPositiveNumbers(){
        negateExpr = new Negate(twentyThree);
        assertTrue(negateExpr.isNegative());
        assertFalse(negateExpr.isPositive());
    }

    @Test
    void withNegativeNumbers(){
        negateExpr = new Negate(minusThirteen);
        assertFalse(negateExpr.isNegative());
        assertTrue(negateExpr.isPositive());
    }

    // -(23 + 7 - 1/(0.2)
    @Test
    void withPositiveComplexExpressions(){
        negateExpr = new Negate(
                new Add(
                        twentyThree,
                        new Subtract(
                                new Number(7f),
                                new Invert(new Number(0.2f))
                        )
                )
        );
        assertEquals(-25f, negateExpr.evaluate());
        assertTrue(negateExpr.isNegative());
    }

    // - (-13 + (-27) - 1/0.1)
    @Test
    void withNegativeComplexExpressions(){
        negateExpr = new Negate(
                new Add(
                        minusThirteen,
                        new Subtract(
                                new Number(-27f),
                                new Invert(new Number(0.1f))
                        )
                )
        );
        assertEquals(50f, negateExpr.evaluate());
        assertTrue(negateExpr.isPositive());
    }

    @Test
    void evaluate() {
        negateExpr = new Negate(minusZero);
        assertEquals(zero.evaluate(), negateExpr.evaluate());

        negateExpr = new Negate(twentyThree);
        assertEquals(twentyThree.evaluate()*(-1F), negateExpr.evaluate());

        negateExpr = new Negate(minusThirteen);
        assertEquals(minusThirteen.evaluate()*(-1F), negateExpr.evaluate());
    }

    @Test
    void evaluateWithComplexExpression() {
        Add opAdd = new Add(twentyThree, minusZero);
        negateExpr = new Negate(opAdd);

        assertTrue(negateExpr.isNegative());
        assertFalse(negateExpr.isPositive());
        assertEquals(twentyThree.evaluate()*(-1F), negateExpr.evaluate());
    }

}