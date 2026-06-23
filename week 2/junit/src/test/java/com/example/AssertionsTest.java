package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


class AssertionsTest {

    @Test
    void theBasicAssertionTypes() {
        assertEquals(5, 2 + 3);
        assertTrue(5 > 3);
        assertFalse(5 < 3);
        assertNull(null);
        assertNotNull(new Object());
    }

    @Test
    void divideByZeroThrows() {
        Calculator calc = new Calculator();
       
        Exception e = assertThrows(IllegalArgumentException.class, () -> calc.divide(5, 0));
        assertEquals("cannot divide by zero", e.getMessage());
    }
}
