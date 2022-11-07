package at.fhj.swd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    private Number num;

    @BeforeEach
    public void setUp(){
        num = new Number(0);
    }

    @Test
    void getValueTest() {
        assertEquals(0, num.getValue(), 0.000001);
    }

    @Test
    public void constructNull(){
        assertThrows(IllegalArgumentException.class, () ->{
            num = new Number(null);
        }, "IllegalArgumentException expected since 'null' was passed as constructor argument, but was not thrown.");
    }

    @Test
    void setValueTest() {
        num.setValue(12);
        assertEquals(12, num.getValue(), 0.000001);
    }

    @Test
    void evaluate() {
        assertEquals(0, num.getValue(), 0.0000001);
        num.setValue(12);
        assertEquals(12, num.evaluate(), 0.000001);
    }
}